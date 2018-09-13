package com.jetblue.api.domain;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

@Document(collection = "airports")
public class Flight {
	@Id
	@JsonProperty("id")
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("airlineCode")
	private String airlineCode;

	public String getAirlineCode() {
		return this.airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	private String flightNumber;

	@JsonProperty("flightNumber")
	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	private String schDate;

	public String getSchDate() {
		return this.schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	private String date;

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String status;

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String originCode;

	public String getOriginCode() {
		return this.originCode;
	}

	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}

	private String originDisplayName;

	public String getOriginDisplayName() {
		return this.originDisplayName;
	}

	public void setOriginDisplayName(String originDisplayName) {
		this.originDisplayName = originDisplayName;
	}

	private boolean showSubText;

	public boolean getShowSubText() {
		return this.showSubText;
	}

	public void setShowSubText(boolean showSubText) {
		this.showSubText = showSubText;
	}

	private String schOriginCode;

	public String getSchOriginCode() {
		return this.schOriginCode;
	}

	public void setSchOriginCode(String schOriginCode) {
		this.schOriginCode = schOriginCode;
	}

	private String destinationCode;

	public String getDestinationCode() {
		return this.destinationCode;
	}

	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}

	private String destinationDisplayName;

	public String getDestinationDisplayName() {
		return this.destinationDisplayName;
	}

	public void setDestinationDisplayName(String destinationDisplayName) {
		this.destinationDisplayName = destinationDisplayName;
	}

	private String destSubText;

	public String getDestSubText() {
		return this.destSubText;
	}

	public void setDestSubText(String destSubText) {
		this.destSubText = destSubText;
	}

	private String schDestinationCode;

	public String getSchDestinationCode() {
		return this.schDestinationCode;
	}

	public void setSchDestinationCode(String schDestinationCode) {
		this.schDestinationCode = schDestinationCode;
	}

	private String ETDDate;

	public String getETDDate() {
		return this.ETDDate;
	}

	public void setETDDate(String ETDDate) {
		this.ETDDate = ETDDate;
	}

	private String ETDTime;

	public String getETDTime() {
		return this.ETDTime;
	}

	public void setETDTime(String ETDTime) {
		this.ETDTime = ETDTime;
	}

	private String ATDDate;

	public String getATDDate() {
		return this.ATDDate;
	}

	public void setATDDate(String ATDDate) {
		this.ATDDate = ATDDate;
	}

	private String ATDTime;

	public String getATDTime() {
		return this.ATDTime;
	}

	public void setATDTime(String ATDTime) {
		this.ATDTime = ATDTime;
	}

	private String STDDate;

	public String getSTDDate() {
		return this.STDDate;
	}

	public void setSTDDate(String STDDate) {
		this.STDDate = STDDate;
	}

	private String STDTime;

	public String getSTDTime() {
		return this.STDTime;
	}

	public void setSTDTime(String STDTime) {
		this.STDTime = STDTime;
	}

	private String currentDepTime;

	public String getCurrentDepTime() {
		return this.currentDepTime;
	}

	public void setCurrentDepTime(String currentDepTime) {
		this.currentDepTime = currentDepTime;
	}

	private String depDescription;

	public String getDepDescription() {
		return this.depDescription;
	}

	public void setDepDescription(String depDescription) {
		this.depDescription = depDescription;
	}

	private String depGate;

	public String getDepGate() {
		return this.depGate;
	}

	public void setDepGate(String depGate) {
		this.depGate = depGate;
	}

	private String depTerminal;

	public String getDepTerminal() {
		return this.depTerminal;
	}

	public void setDepTerminal(String depTerminal) {
		this.depTerminal = depTerminal;
	}

	private String EDCT;

	public String getEDCT() {
		return this.EDCT;
	}

	public void setEDCT(String EDCT) {
		this.EDCT = EDCT;
	}

	private String OutDate;

	public String getOutDate() {
		return this.OutDate;
	}

	public void setOutDate(String OutDate) {
		this.OutDate = OutDate;
	}

	private String OutTime;

	public String getOutTime() {
		return this.OutTime;
	}

	public void setOutTime(String OutTime) {
		this.OutTime = OutTime;
	}

	private String OffDate;

	public String getOffDate() {
		return this.OffDate;
	}

	public void setOffDate(String OffDate) {
		this.OffDate = OffDate;
	}

	private String OffTime;

	public String getOffTime() {
		return this.OffTime;
	}

	public void setOffTime(String OffTime) {
		this.OffTime = OffTime;
	}

	private String depDelayCount;

	public String getDepDelayCount() {
		return this.depDelayCount;
	}

	public void setDepDelayCount(String depDelayCount) {
		this.depDelayCount = depDelayCount;
	}

	private String depDelayCodes;

	public String getDepDelayCodes() {
		return this.depDelayCodes;
	}

	public void setDepDelayCodes(String depDelayCodes) {
		this.depDelayCodes = depDelayCodes;
	}

	private String ETADate;

	public String getETADate() {
		return this.ETADate;
	}

	public void setETADate(String ETADate) {
		this.ETADate = ETADate;
	}

	private String ETATime;

	public String getETATime() {
		return this.ETATime;
	}

	public void setETATime(String ETATime) {
		this.ETATime = ETATime;
	}

	private String ATADate;

	public String getATADate() {
		return this.ATADate;
	}

	public void setATADate(String ATADate) {
		this.ATADate = ATADate;
	}

	private String ATATime;

	public String getATATime() {
		return this.ATATime;
	}

	public void setATATime(String ATATime) {
		this.ATATime = ATATime;
	}

	private String STADate;

	public String getSTADate() {
		return this.STADate;
	}

	public void setSTADate(String STADate) {
		this.STADate = STADate;
	}

	private String STATime;

	public String getSTATime() {
		return this.STATime;
	}

	public void setSTATime(String STATime) {
		this.STATime = STATime;
	}

	private String currentArrTime;

	public String getCurrentArrTime() {
		return this.currentArrTime;
	}

	public void setCurrentArrTime(String currentArrTime) {
		this.currentArrTime = currentArrTime;
	}

	private String arrDescription;

	public String getArrDescription() {
		return this.arrDescription;
	}

	public void setArrDescription(String arrDescription) {
		this.arrDescription = arrDescription;
	}

	private String arrGate;

	public String getArrGate() {
		return this.arrGate;
	}

	public void setArrGate(String arrGate) {
		this.arrGate = arrGate;
	}

	private String arrTerminal;

	public String getArrTerminal() {
		return this.arrTerminal;
	}

	public void setArrTerminal(String arrTerminal) {
		this.arrTerminal = arrTerminal;
	}

	private String OnDate;

	public String getOnDate() {
		return this.OnDate;
	}

	public void setOnDate(String OnDate) {
		this.OnDate = OnDate;
	}

	private String OnTime;

	public String getOnTime() {
		return this.OnTime;
	}

	public void setOnTime(String OnTime) {
		this.OnTime = OnTime;
	}

	private String InDate;

	public String getInDate() {
		return this.InDate;
	}

	public void setInDate(String InDate) {
		this.InDate = InDate;
	}

	private String InTime;

	public String getInTime() {
		return this.InTime;
	}

	public void setInTime(String InTime) {
		this.InTime = InTime;
	}

	private String arrDelayCount;

	public String getArrDelayCount() {
		return this.arrDelayCount;
	}

	public void setArrDelayCount(String arrDelayCount) {
		this.arrDelayCount = arrDelayCount;
	}

	private String arrDelayCodes;

	public String getArrDelayCodes() {
		return this.arrDelayCodes;
	}

	public void setArrDelayCodes(String arrDelayCodes) {
		this.arrDelayCodes = arrDelayCodes;
	}

	private String schDuration;

	public String getSchDuration() {
		return this.schDuration;
	}

	public void setSchDuration(String schDuration) {
		this.schDuration = schDuration;
	}

	private String arrClaim;

	public String getArrClaim() {
		return this.arrClaim;
	}

	public void setArrClaim(String arrClaim) {
		this.arrClaim = arrClaim;
	}

	private String equipmentType;

	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	private String tailNumber;

	public String getTailNumber() {
		return this.tailNumber;
	}

	public void setTailNumber(String tailNumber) {
		this.tailNumber = tailNumber;
	}

	private String acftRegNumber;

	public String getAcftRegNumber() {
		return this.acftRegNumber;
	}

	public void setAcftRegNumber(String acftRegNumber) {
		this.acftRegNumber = acftRegNumber;
	}

	private String codeshareFlightsCount;

	public String getCodeshareFlightsCount() {
		return this.codeshareFlightsCount;
	}

	public void setCodeshareFlightsCount(String codeshareFlightsCount) {
		this.codeshareFlightsCount = codeshareFlightsCount;
	}

	private CodeshareFlightsDetails codeshareFlightsDetails;

	public CodeshareFlightsDetails getCodeshareFlightsDetails() {
		return this.codeshareFlightsDetails;
	}

	public void setCodeshareFlightsDetails(CodeshareFlightsDetails codeshareFlightsDetails) {
		this.codeshareFlightsDetails = codeshareFlightsDetails;
	}

	private boolean updateDelayCodeEnabled;

	public boolean getUpdateDelayCodeEnabled() {
		return this.updateDelayCodeEnabled;
	}

	public void setUpdateDelayCodeEnabled(boolean updateDelayCodeEnabled) {
		this.updateDelayCodeEnabled = updateDelayCodeEnabled;
	}

	private boolean updateFlightStatusEnabled;

	public boolean getUpdateFlightStatusEnabled() {
		return this.updateFlightStatusEnabled;
	}

	public void setUpdateFlightStatusEnabled(boolean updateFlightStatusEnabled) {
		this.updateFlightStatusEnabled = updateFlightStatusEnabled;
	}

	private String dispatchLink;

	public String getDispatchLink() {
		return this.dispatchLink;
	}

	public void setDispatchLink(String dispatchLink) {
		this.dispatchLink = dispatchLink;
	}

	private BoardingStatus boardingStatus;

	public BoardingStatus getBoardingStatus() {
		return this.boardingStatus;
	}

	public void setBoardingStatus(BoardingStatus boardingStatus) {
		this.boardingStatus = boardingStatus;
	}

	private FuelDetails FuelDetails;

	public FuelDetails getFuelDetails() {
		return this.FuelDetails;
	}

	public void setFuelDetails(FuelDetails FuelDetails) {
		this.FuelDetails = FuelDetails;
	}

	private String eventType;

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
}
