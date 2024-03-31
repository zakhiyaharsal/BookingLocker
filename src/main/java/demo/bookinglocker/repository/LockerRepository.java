package demo.bookinglocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.bookinglocker.model.Locker;

public interface LockerRepository extends JpaRepository<Locker, Integer>{
    List<Locker> findListLockerByAlias(String Alias);
    List<Locker> findListLockerByLockerNumber (int LockerNumber);
    Locker findLockerByAlias(String Alias);
    Locker findLockerByLockerNumber (int LockerNumber);
    Locker findLockerByLockerNumberAndAvailability (int LockerNumber,boolean Availability);
    
    
}
