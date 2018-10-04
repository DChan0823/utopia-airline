package com.smoothstack.utopia.counter.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "User_has_Reservation")
public class UserHasReservation {
	@ManyToOne(fetch = FetchType.LAZY)    
	@JoinColumn(name="User_id", insertable = false, updatable = false)
	User user;
	@ManyToOne(fetch = FetchType.LAZY)    
	@JoinColumn(name="Reservation_id", insertable = false, updatable = false)
	Reservation reservation;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
