package demo.bookinglocker.service;


import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import demo.bookinglocker.model.Booking;

@Component
public interface BookingService {
    void addBooking(Booking booking);   
    Booking addBooking (int userId,int lockerNumber,Date Stardate,Date Endate,BigInteger deposit,BigInteger fine,BigInteger saldo);
    //Booking addBooking (User user,int lockerNumber,Date Stardate,Date Endate,BigInteger deposit,BigInteger fine);
    //List<BookingInfoDto> getBookingInfo();
    //Locker updateAfterFailAttempt (int lockerNumber,boolean availability,int failPasswordCount);
    Booking updateAfter3FailAttempt (int lockerNumber);
    Booking Get(int lockerNumber);
    Map<String, Object> findBookingInfo(int lockerNumber);
}
