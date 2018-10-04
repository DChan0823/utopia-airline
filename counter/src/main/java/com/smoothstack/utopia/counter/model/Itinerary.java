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
@Table(name = "Itinerary")
public class Itinerary {
	@Id
	Integer id;
	@Column(name="total_price")
	Integer totalPrice;
	@JsonIgnore    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Itinerary_id", cascade = CascadeType.ALL)    
	private Set<Ticket> tickets;
	@JsonIgnore    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Itinerary_id", cascade = CascadeType.ALL)    
	private Set<ItineraryHasFlight> hasFlights;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Set<ItineraryHasFlight> getHasFlights() {
		return hasFlights;
	}
	public void setHasFlights(Set<ItineraryHasFlight> hasFlights) {
		this.hasFlights = hasFlights;
	}
}
