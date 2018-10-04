package com.smoothstack.utopia.counter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.utopia.counter.dao.FlightDao;
import com.smoothstack.utopia.counter.dao.SeatDao;
import com.smoothstack.utopia.counter.model.Flight;
import com.smoothstack.utopia.counter.model.Seat;
import com.smoothstack.utopia.counter.model.Ticket;

@RestController
@CrossOrigin
@RequestMapping(path="/counter")
public class CounterController {
	// TODO: inject DAO beans
	@Autowired
	FlightDao fdao;
	@Autowired
	SeatDao sdao;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path="/flights",method=RequestMethod.GET)
	public List<Flight> getFlights(){
		return fdao.findAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path="/flight/{flightId}/seats",method=RequestMethod.GET)
	public List<Seat> getSeatsByFlight(@PathVariable("flightId") Integer flightId){
		// TODO
		return sdao.findAllByFlight(flightId);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/flights/{flightId}/seats/{seatNo}",method=RequestMethod.POST)
	public Ticket bookTicket(@PathVariable("flightId") Integer flightId, @PathVariable("seatNo") Integer seatNo) {
		// TODO: create a reservation and an itinerary, then a ticket to link them
		return null;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path="/ticket",method=RequestMethod.DELETE)
	public void cancelTicket(Ticket ticket) {
		// TODO
	}
}
