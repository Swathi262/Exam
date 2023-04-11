package com.cg.onlineassesment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineassesment.entity.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
	Iterable<Booking> findAll();
}
