package com.example.demo.service;

import com.example.demo.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();
    Booking saveBooking(Booking booking, Long trainerId, Long userId);
    Booking getBookingById(Long Id);
    void removeById(Long Id);
}
