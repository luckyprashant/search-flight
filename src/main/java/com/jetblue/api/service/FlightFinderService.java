package com.jetblue.api.service;

import com.jetblue.api.domain.FlightInput;
import com.jetblue.api.domain.FlightResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface FlightFinderService.
 */
public interface FlightFinderService {

	/**
	 * Fetch flight by number.
	 *
	 * @param flight the flight
	 * @return the flight response
	 */
	public FlightResponse fetchFlightByNumber(final FlightInput flight);
	
	/**
	 * Fetch flight by date.
	 *
	 * @param date the date
	 * @return the flight response
	 */
	public FlightResponse fetchFlightByDate(final String date);
	
	/**
	 * Find by origin code destination code.
	 *
	 * @param originCode the origin code
	 * @param destinationCode the destination code
	 * @return the flight response
	 */
	public FlightResponse findByOriginCodeDestinationCode(final String originCode, final String destinationCode);

	/**
	 * Fetch flight by number async.
	 *
	 * @param flight the flight
	 * @return the flight response
	 * @throws InterruptedException the interrupted exception
	 */
	public FlightResponse fetchFlightByNumberAsync(final FlightInput flight) throws InterruptedException;

	/**
	 * Fetch flight by date async.
	 *
	 * @param date the date
	 * @return the flight response
	 * @throws InterruptedException the interrupted exception
	 */
	public FlightResponse fetchFlightByDateAsync(final String date) throws InterruptedException;

	/**
	 * Find by origin code destination code async.
	 *
	 * @param flight the flight
	 * @return the flight response
	 * @throws InterruptedException the interrupted exception
	 */
	public FlightResponse findByOriginCodeDestinationCodeAsync(final FlightInput flight) throws InterruptedException;
	
}
