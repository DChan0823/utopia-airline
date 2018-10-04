package com.smoothstack.utopia.counter.dao;

import org.springframework.stereotype.Repository;
import com.smoothstack.utopia.counter.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer> {

}
