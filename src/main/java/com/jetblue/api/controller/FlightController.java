package com.jetblue.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jetblue.api.domain.FlightInput;
import com.jetblue.api.domain.FlightResponse;
import com.jetblue.api.service.FlightFinderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class FlightController {

//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FlightFinderService flightFinderService;

	/**
	 * Gets the flight by number async.
	 *
	 * @param flight the flight
	 * @return the flight by number async
	 * @throws InterruptedException the interrupted exception
	 */
	@PostMapping(value = "/fetch-flight-by-number-async", produces = { "application/xml", "application/json" }, consumes = { "application/xml", "application/json" })
	@ApiOperation(value = "To fetch flight details by passed number async", response = ResponseEntity.class)
	public ResponseEntity<?> getFlightByNumberAsync(@RequestBody FlightInput flight) throws InterruptedException {
		FlightResponse response = flightFinderService.fetchFlightByNumberAsync(flight);
		return new ResponseEntity<FlightResponse>(response, HttpStatus.OK);
	}

	/**
	 * Gets the flight by date async.
	 *
	 * @param flight the flight
	 * @return the flight by date async
	 * @throws InterruptedException the interrupted exception
	 */
	@PostMapping(value = "/fetch-flight-by-date-async", produces = { "application/xml", "application/json" }, consumes = { "application/xml", "application/json" })
	@ApiOperation(value = "To fetch flight details by passed date async", response = ResponseEntity.class)
	public ResponseEntity<?> getFlightByDateAsync(@RequestParam String date) throws InterruptedException {
		FlightResponse response = flightFinderService.fetchFlightByDateAsync(date);
		return new ResponseEntity<FlightResponse>(response, HttpStatus.OK);
	}

	/**
	 * Gets the flight by org des async.
	 *
	 * @param flight the flight
	 * @return the flight by org des async
	 * @throws InterruptedException the interrupted exception
	 */
	@PostMapping(value = "/fetch-flight-by-orgin-destination-async", produces = { "application/xml", "application/json" }, consumes = { "application/xml", "application/json" })
	@ApiOperation(value = "To fetch flight details by passed origin destination async", response = ResponseEntity.class)
	public ResponseEntity<?> getFlightByOrgDesAsync(@RequestBody FlightInput flight) throws InterruptedException {
		FlightResponse response = flightFinderService.findByOriginCodeDestinationCodeAsync(flight);
		return new ResponseEntity<FlightResponse>(response, HttpStatus.OK);
	}

	/**
	 * Gets the flight by number.
	 *
	 * @param flight the flight
	 * @return the flight by number
	 */
	@PostMapping(value = "/fetch-flight-by-number", produces = { "application/xml", "application/json" }, consumes = { "application/xml", "application/json" })
	@ApiOperation(value = "To fetch flight details by passed number", response = ResponseEntity.class)
	public ResponseEntity<?> getFlightByNumber(@RequestBody FlightInput flight) {
		FlightResponse response = flightFinderService.fetchFlightByNumber(flight);
		return new ResponseEntity<FlightResponse>(response, HttpStatus.OK);
	}

	/**
	 * Gets the flight by date.
	 *
	 * @param date the date
	 * @return the flight by date
	 */
	@PostMapping(value = "/fetch-flight-by-date", produces = { "application/xml", "application/json" }, consumes = { "application/xml", "application/json" })
	@ApiOperation(value = "To fetch flight details by passed date", response = ResponseEntity.class)
	public ResponseEntity<?> getFlightByDate(@RequestParam String date) {
		FlightResponse response = flightFinderService.fetchFlightByDate(date);
		return new ResponseEntity<FlightResponse>(response, HttpStatus.OK);
	}

	/**
	 * Gets the flight by org des.
	 *
	 * @param flight the flight
	 * @return the flight by org des
	 */
	@PostMapping(value = "/fetch-flight-by-orgin-destination", produces = { "application/xml", "application/json" }, consumes = { "application/xml", "application/json" })
	@ApiOperation(value = "To fetch flight details by passed origin destination", response = ResponseEntity.class)
	public ResponseEntity<?> getFlightByOrgDes(@RequestBody FlightInput flight) {
		FlightResponse response = flightFinderService.findByOriginCodeDestinationCode(flight.getOriginCode(), flight.getDestinationCode());
		return new ResponseEntity<FlightResponse>(response, HttpStatus.OK);
	}

}
