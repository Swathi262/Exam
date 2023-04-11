package com.cg.onlineassesment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineassesment.dao.BookingDTO;
import com.cg.onlineassesment.service.BookingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	@Autowired
	public BookingService bookingService;
	 
    //http://localhost:9091/api/candidate/addBooking
    @PostMapping("/addBooking")
    public ResponseEntity<BookingDTO> addBooking(@RequestBody BookingDTO booking) {

        BookingDTO savebooking = bookingService.addBooking(booking);
        return ResponseEntity.ok(savebooking);

    }

    @GetMapping("/fetchBookingById/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable int id) {
        BookingDTO bookingDTO = bookingService.getById(id);
        return new ResponseEntity<BookingDTO>(bookingDTO, HttpStatus.FOUND);
    }

    @PutMapping("/updateBooking")
    public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDTO) {
        return new ResponseEntity<BookingDTO>(bookingService.updateBooking(bookingDTO), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<?> deleteBookingById(@PathVariable int id) {
        BookingDTO bookingDTO = bookingService.getById(id);
        if (bookingDTO != null) {
            bookingService.deleteBooking(bookingDTO);
            return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
            }
        return new ResponseEntity<String>("The Booking id"+ id +"does not exists",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/fetchAllBooking")
    public ResponseEntity<List<BookingDTO>> getAllBooking() {
        List<BookingDTO> list = bookingService.findAll();
        return ResponseEntity.ok(list);
        }


}
