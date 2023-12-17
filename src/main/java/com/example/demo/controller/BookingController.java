package com.example.demo.controller;
import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping("/booking/{trainerId}/{userId}")
    public Booking save(@RequestBody Booking booking, @PathVariable ("trainerId")Long trainerId, @PathVariable ("userId") Long userId){
        return bookingService.saveBooking(booking, trainerId, userId);
    }

    @GetMapping("/bookings")
    public List<Booking> bookingList(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/booking/{id}")
    public Booking getBookingById(@PathVariable("id") Long id){
        return bookingService.getBookingById(id);
    }

    @DeleteMapping("/booking/{id}")
    public void removeById(@PathVariable("id") Long id){
        bookingService.removeById(id);
    }




}
