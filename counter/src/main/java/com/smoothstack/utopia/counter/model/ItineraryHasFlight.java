package com.smoothstack.utopia.counter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Itinerary_has_Flight")
public class ItineraryHasFlight {
	@ManyToOne(fetch = FetchType.LAZY)    
	@JoinColumn(name="Itinerary_id", insertable = false, updatable = false)
	Itinerary itinerary;
	@ManyToOne(fetch = FetchType.LAZY)    
	@JoinColumn(name="Flight_id", insertable = false, updatable = false)
	Flight flight;
	@Column(name="class")
	char flightClass;
	@Column(name="seat_id")
	Seat seat;
	
	public Itinerary getItinerary() {
		return itinerary;
	}
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public char getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(char flightClass) {
		this.flightClass = flightClass;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
