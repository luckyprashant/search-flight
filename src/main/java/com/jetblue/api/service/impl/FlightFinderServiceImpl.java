package com.jetblue.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jetblue.api.domain.Flight;
import com.jetblue.api.domain.FlightInput;
import com.jetblue.api.domain.FlightResponse;
import com.jetblue.api.repo.FlightRepository;
import com.jetblue.api.service.FlightFinderService;
import com.microsoft.azure.cosmosdb.Document;
import com.microsoft.azure.cosmosdb.FeedOptions;
import com.microsoft.azure.cosmosdb.FeedResponse;
import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;

import rx.Observable;

/**
 * The Class FlightFinderServiceImpl.
 */
@Service
public class FlightFinderServiceImpl implements FlightFinderService {

	private final static Logger LOG = LoggerFactory.getLogger(FlightFinderServiceImpl.class);

	@Autowired
	private FlightRepository flightRepository;

	@Value("${azure.documentdb.database}")
	private String dbName;

	@Autowired
	private AsyncDocumentClient cosmosDbClient;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jetblue.api.service.FlightFinderService#fetchFlightByNumber(com.jetblue.
	 * api.domain.FlightInput)
	 */
	@Override
	public FlightResponse fetchFlightByNumber(FlightInput flightDomain) {
		Optional<List<Flight>> flight = flightRepository.findByAirlineCodeAndFlightNumber(flightDomain.getAirlineCode(),
				flightDomain.getFlightNumber());
		if (flight.isPresent()) {
			FlightResponse model = new FlightResponse();
			model.setFlightList(flight.get());
			return model;
		}
		LOG.error("Flight not found");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jetblue.api.service.FlightFinderService#fetchFlightByDate(java.lang.
	 * String)
	 */
	@Override
	public FlightResponse fetchFlightByDate(String date) {
		Optional<List<Flight>> flight = flightRepository.findBySchDate(date);
		if (flight.isPresent()) {
			FlightResponse model = new FlightResponse();
			model.setFlightList(flight.get());
			return model;
		}
		LOG.error("Flight not found");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jetblue.api.service.FlightFinderService#findByOriginCodeDestinationCode(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public FlightResponse findByOriginCodeDestinationCode(String originCode, String destinationCode) {
		Optional<List<Flight>> flight = flightRepository.findByOriginCodeAndDestinationCode(originCode,
				destinationCode);
		if (flight.isPresent()) {
			FlightResponse model = new FlightResponse();
			model.setFlightList(flight.get());
			return model;
		}
		LOG.error("Flight not found");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jetblue.api.service.FlightFinderService#fetchFlightByNumberAsync(com.
	 * jetblue.api.domain.FlightInput)
	 */
	@Override
	public FlightResponse fetchFlightByNumberAsync(FlightInput flightDomain) throws InterruptedException {
		CountDownLatch completionLatch = new CountDownLatch(1);
		
		String collectionLink = String.format("/dbs/%s/colls/%s", dbName, "airports");
		String query = String.format(
				"SELECT * FROM Flight WHERE Flight.airlineCode = '%s' AND Flight.flightNumber = '%s'", flightDomain.getAirlineCode(), flightDomain.getFlightNumber());
		Observable<FeedResponse<Document>> queryObservable = cosmosDbClient.queryDocuments(collectionLink, query, getQueryFeedOptions());
		
		List<Flight> flights = getFlights(queryObservable, completionLatch);
		return getFlightModel(flights);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jetblue.api.service.FlightFinderService#fetchFlightByDateAsync(java.lang.
	 * String)
	 */
	@Override
	public FlightResponse fetchFlightByDateAsync(String date) throws InterruptedException {
		CountDownLatch completionLatch = new CountDownLatch(1);
		
		String collectionLink = String.format("/dbs/%s/colls/%s", dbName, "airports");
		String query = String.format("SELECT * FROM Flight WHERE Flight.schDate = '%s'", date);
		Observable<FeedResponse<Document>> queryObservable = cosmosDbClient.queryDocuments(collectionLink, query,
				getQueryFeedOptions());
		
		List<Flight> flights = getFlights(queryObservable, completionLatch);
		return getFlightModel(flights);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jetblue.api.service.FlightFinderService#
	 * findByOriginCodeDestinationCodeAsync(com.jetblue.api.domain.FlightInput)
	 */
	@Override
	public FlightResponse findByOriginCodeDestinationCodeAsync(FlightInput flightDomain) throws InterruptedException {
		CountDownLatch completionLatch = new CountDownLatch(1);
		
		String collectionLink = String.format("/dbs/%s/colls/%s", dbName, "airports");
		String query = String.format(
				"SELECT * FROM Flight WHERE Flight.originCode = '%s' AND Flight.destinationCode = '%s'",
				flightDomain.getOriginCode(), flightDomain.getDestinationCode());
		Observable<FeedResponse<Document>> queryObservable = cosmosDbClient.queryDocuments(collectionLink, query, getQueryFeedOptions());
		
		List<Flight> flights = getFlights(queryObservable, completionLatch);
		return getFlightModel(flights);
	}
	

	/**
	 * Gets the flight model.
	 *
	 * @param flights the flights
	 * @return the flight model
	 */
	private FlightResponse getFlightModel(List<Flight> flights) {
		FlightResponse model = new FlightResponse();
		model.setFlightList(flights);
		return model;
	}

	/**
	 * Gets the query feed options.
	 *
	 * @return the query feed options
	 */
	private FeedOptions getQueryFeedOptions() {
		// Set some common query options
		FeedOptions queryOptions = new FeedOptions();
		queryOptions.setMaxItemCount(100);
		queryOptions.setEnableCrossPartitionQuery(true);
		return queryOptions;
	}

	/**
	 * Gets the flights.
	 *
	 * @param queryObservable the query observable
	 * @param completionLatch the completion latch
	 * @return the flights
	 * @throws InterruptedException the interrupted exception
	 */
	private List<Flight> getFlights(Observable<FeedResponse<Document>> queryObservable, CountDownLatch completionLatch)
			throws InterruptedException {
		List<Flight> flights = new ArrayList<>();
		queryObservable.subscribe(queryResultPage -> {
			queryResultPage.getResults().forEach(fl -> {
				Flight flightRes = fl.toObject(Flight.class);
				flights.add(flightRes);
			});
		},

				// terminal error signal
				e -> {
					e.printStackTrace();
					completionLatch.countDown();
				},

				// terminal completion signal
				() -> {
					completionLatch.countDown();
				});

		completionLatch.await(); // Wait for query to complete
		return flights;
	}

}
