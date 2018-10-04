package com.smoothstack.utopia.counter.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Reservation")
public class Reservation {
	@Id
	Integer id;
	@Column(name="Itinerary_id")
	Integer itineraryId;
	@Column(name="booked_by")
	String bookedBy; // No idea what this is
	@JsonIgnore    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reservation_id", cascade = CascadeType.ALL)    
	Set<Ticket> tickets;
	@JsonIgnore    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reservation_id", cascade = CascadeType.ALL)    
	Set<UserHasReservation> hasUsers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItineraryId() {
		return itineraryId;
	}
	public void setItineraryId(Integer itineraryId) {
		this.itineraryId = itineraryId;
	}
	public String getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Set<UserHasReservation> getHasUsers() {
		return hasUsers;
	}
	public void setHasUsers(Set<UserHasReservation> hasUsers) {
		this.hasUsers = hasUsers;
	}
}
