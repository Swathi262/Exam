package com.cg.onlineassesment.service;

import java.util.List;

import com.cg.onlineassesment.dao.BookingDTO;

public interface BookingService {
	public BookingDTO addBooking(BookingDTO booking);

    public BookingDTO updateBooking(BookingDTO bookingDTO);

    public boolean deleteBooking(BookingDTO bookingDTO);

    public BookingDTO getById( int id);

    public List<BookingDTO> findAll();

}
