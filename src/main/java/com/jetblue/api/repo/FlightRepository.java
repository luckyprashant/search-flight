package com.jetblue.api.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jetblue.api.domain.Flight;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

@Repository
public interface FlightRepository extends DocumentDbRepository<Flight, String> {  

	List<Flight> findAll();
	
	public Optional<List<Flight>> findByAirlineCodeAndFlightNumber(final String airlineCode, final String flightNumber);
	
	public Optional<List<Flight>> findBySchDate(final String schDate);
	
	public Optional<List<Flight>> findByOriginCodeAndDestinationCode(final String originCode, final String destinationCode);
}
