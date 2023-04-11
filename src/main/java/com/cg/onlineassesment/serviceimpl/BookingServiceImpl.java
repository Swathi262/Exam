package com.cg.onlineassesment.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineassesment.dao.BookingDTO;
import com.cg.onlineassesment.entity.Booking;
import com.cg.onlineassesment.repository.BookingRepository;
import com.cg.onlineassesment.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	 private BookingRepository bookingRepository;
	
	
	@Override
	public BookingDTO addBooking(BookingDTO bookingDto) {
		// TODO Auto-generated method stub
	    
		Booking booking1 = new Booking();
        BeanUtils.copyProperties(bookingDto, booking1);
        Booking bookingSave=bookingRepository.save(booking1);
        bookingDto.setBookingid(bookingSave.getBookingid());
        booking1.setExamid(bookingDto.getExamid());
        booking1.setCandidateid(bookingDto.getCandidateid());
        booking1.setBookingdate(bookingDto.getBookingdate());
        return bookingDto;


	}

	@Override
	public BookingDTO updateBooking(BookingDTO bookingDTO) {
		// TODO Auto-generated method stub
		 
		Booking booking = new Booking();
		        booking.setBookingid(bookingDTO.getBookingid());
		        booking.setExamid(bookingDTO.getExamid());
		        booking.setCandidateid(bookingDTO.getCandidateid());
		        booking.setBookingdate(bookingDTO.getBookingdate());    
		        Booking saveId=bookingRepository.save(booking);
		        bookingDTO.setBookingid(saveId.getBookingid());

		        return bookingDTO;

	}

	@Override
	public boolean deleteBooking(BookingDTO bookingDTO) {
		// TODO Auto-generated method stub
		Booking booking = new Booking();
        booking.setBookingid(bookingDTO.getBookingid());
        bookingRepository.delete(booking);
        return true;

	}

	@Override
	public BookingDTO getById(int id) {
		// TODO Auto-generated method stub
		Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            BookingDTO dto = new BookingDTO();
            BeanUtils.copyProperties(booking.get(), dto);
            return dto;
        }

		return null;
	}

	@Override
	public List<BookingDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<Booking> booking = bookingRepository.findAll();
        List<BookingDTO> dtos = new ArrayList<>();
        for (Booking bookings : booking) {
            BookingDTO dto = new BookingDTO();
            BeanUtils.copyProperties(bookings, dto);
            dtos.add(dto);
        }

		return null;
	}

}
