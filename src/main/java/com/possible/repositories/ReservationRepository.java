package com.possible.repositories;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import com.possible.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	
	Iterable<Reservation> findReservationByReservationDate(Date date);
}
