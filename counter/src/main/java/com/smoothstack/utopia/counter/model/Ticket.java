package com.smoothstack.utopia.counter.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Ticket")
public class Ticket {
	@ManyToOne(fetch = FetchType.LAZY)    
	@JoinColumn(name="Reservation_id", insertable = false, updatable = false)
	Reservation reservation;
	@ManyToOne(fetch = FetchType.LAZY)    
	@JoinColumn(name="Itinerary_id", insertable = false, updatable = false)
	Itinerary itinerary;
	
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Itinerary getItinerary() {
		return itinerary;
	}
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
}
