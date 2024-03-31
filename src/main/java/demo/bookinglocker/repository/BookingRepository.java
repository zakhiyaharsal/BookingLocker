package demo.bookinglocker.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.bookinglocker.model.Booking;
//import demo.bookinglocker.model.BookingInfoDto;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findListBookingByLockerNumber(int lockerNumber);
    Booking findBookingByLockerNumber(int lockerNumber);

     @Query(value = "SELECT a.LOCKER_NUMBER as lockerNumber, a.USER_ID as userId, b.password as password, c.email as email FROM lockers b LEFT JOIN bookings a ON a.LOCKER_NUMBER=b.LOCKER_NUMBER LEFT JOIN users c ON a.USER_ID=c.ID WHERE a.locker_number=?1", nativeQuery = true)
    Map<String, Object> findBookingInfo(int lockerNumber);
}
