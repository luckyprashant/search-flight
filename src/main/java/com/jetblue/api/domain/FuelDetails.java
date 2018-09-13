package com.jetblue.api.domain;

public class FuelDetails {

	private Departure Departure;

	public Departure getDeparture() {
		return this.Departure;
	}

	public void setDeparture(Departure Departure) {
		this.Departure = Departure;
	}

	private Arrival Arrival;

	public Arrival getArrival() {
		return this.Arrival;
	}

	public void setArrival(Arrival Arrival) {
		this.Arrival = Arrival;
	}

	private Burned Burned;

	public Burned getBurned() {
		return this.Burned;
	}

	public void setBurned(Burned Burned) {
		this.Burned = Burned;
	}
}
