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
@Table(name = "Flight")
public class Flight {
	@Id
	Integer id;
	@Column(name="from_airport")
	String fromAirport;
	@Column(name="to_airport")
	String toAirport;
	@Column(name="departure_date")
	String departureDate; // change to date?
	@Column(name="arrival_date")
	String arrivalDate;
	@Column(name="economy_price")
	Integer economyPrice;
	@Column(name="business_price")
	Integer businessPrice;
	@JsonIgnore    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Flight_id", cascade = CascadeType.ALL)    
	private Set<Seat> seats;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFromAirport() {
		return fromAirport;
	}
	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}
	public String getToAirport() {
		return toAirport;
	}
	public void setToAirport(String toAirport) {
		this.toAirport = toAirport;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Integer getEconomyPrice() {
		return economyPrice;
	}
	public void setEconomyPrice(Integer economyPrice) {
		this.economyPrice = economyPrice;
	}
	public Integer getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(Integer businessPrice) {
		this.businessPrice = businessPrice;
	}
	public Set<Seat> getSeats() {
		return seats;
	}
	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}
	
	
}
