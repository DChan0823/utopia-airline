package com.smoothstack.utopia.counter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smoothstack.utopia.counter.model.Seat;

@Repository
public interface SeatDao extends JpaRepository<Seat, Integer>{
	@Query("SELECT s FROM Seat s WHERE s.flight = ?1")
	List<Seat> findAllByFlight(Integer flightId);
}
