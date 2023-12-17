package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.Trainer;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepo;
import com.example.demo.repository.TrainerRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {


    private BookingRepo bookingRepo;
    private TrainerRepo trainerRepo;
    private UserRepo userRepo;

    public BookingServiceImpl(BookingRepo bookingRepo, TrainerRepo trainerRepo, UserRepo userRepo) {
        this.bookingRepo = bookingRepo;
        this.trainerRepo = trainerRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Booking saveBooking(Booking booking, Long trainerId, Long userId) {
        Trainer trainer = trainerRepo.findTrainerById(trainerId);
        User user = userRepo.findUserById(userId);
        booking.setTrainer(trainer);
        booking.setUser(user);
        return bookingRepo.save(booking);
    }

    @Override
    public Booking getBookingById(Long Id) {
        return bookingRepo.findBookingById(Id);
    }

    @Override
    public void removeById(Long Id) {
        bookingRepo.deleteById(Id);
    }
}
