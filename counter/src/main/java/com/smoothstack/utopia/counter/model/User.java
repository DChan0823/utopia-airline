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
@Table(name = "User")
public class User {
	@Id
	Integer id;
	@Column(name="name")
	String name;
	@Column(name="email")
	String email;
	@Column(name="role")
	String role; // this could be made a char or enumeration or something
	@Column(name="password")
	String password; // TODO: hash this maybe?
	@JsonIgnore    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "User_id", cascade = CascadeType.ALL)    
	private Set<UserHasReservation> hasReservations;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<UserHasReservation> getHasReservations() {
		return hasReservations;
	}
	public void setHasReservations(Set<UserHasReservation> hasReservations) {
		this.hasReservations = hasReservations;
	}
}
