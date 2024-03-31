package demo.bookinglocker.service;


import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.bookinglocker.model.Booking;

import demo.bookinglocker.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Override
    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }
    @Override
    public Booking addBooking(int userId, int lockerNumber, Date Stardate, Date Endate, BigInteger deposit,
           BigInteger fine,BigInteger saldo) {
        Booking booking = new Booking();
        //booking.user = new User(userId); // Fix: Create a new User object using the userId.
        booking.userId=userId;
        booking.lockerNumber=lockerNumber;
        booking.startDate=Stardate;
        booking.endDate=Endate;
        booking.deposit=deposit;
        booking.fine=fine;
        booking.saldo=saldo;
        return bookingRepository.save(booking);
    }

    

    @Override
    public Map<String, Object> findBookingInfo(int lockerNumber) {
        return bookingRepository.findBookingInfo(lockerNumber);
    }
 
    @Override
    public Booking updateAfter3FailAttempt(int lockerNumber) {
        Booking bookingUpdateFineAfterFailAttempt3 = bookingRepository.findBookingByLockerNumber(lockerNumber);
        bookingUpdateFineAfterFailAttempt3.setFine(BigInteger.valueOf(25000));
        bookingUpdateFineAfterFailAttempt3.setDeposit(BigInteger.valueOf(0));
        return bookingRepository.save(bookingUpdateFineAfterFailAttempt3);
    }
    @Override
    public Booking Get(int lockerNumber) {
        return bookingRepository.findBookingByLockerNumber(lockerNumber);
    }
    
}
