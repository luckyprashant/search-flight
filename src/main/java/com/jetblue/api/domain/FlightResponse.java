package com.jetblue.api.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class FlightResponse {

	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("flights")
	private List<Flight> flights;

	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("flights")
	public List<Flight> getFlight() {
		if(null == flights) {
			flights = new ArrayList<>();
		}
		return flights;
	}

	public void addFlight(Flight flight) {
		if(null == flights) {
			flights = new ArrayList<>();
		}
		flights.add(flight);
	}
	
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("flights")
	public void setFlightList(List<Flight> flightList) {
		if(null == this.flights) {
			this.flights = new ArrayList<>();
		}
		this.flights.addAll(flightList);
	}
}
