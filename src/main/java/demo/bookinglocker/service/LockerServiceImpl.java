package demo.bookinglocker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.bookinglocker.model.Locker;
import demo.bookinglocker.repository.LockerRepository;

@Service
public class LockerServiceImpl implements LockerService{
    @Autowired
    LockerRepository lockerRepository;
    @Override
    public void addLocker(int lockerNumber) {
        throw new UnsupportedOperationException("Unimplemented method 'addLocker'");
    }
    @Override
    public Locker addLocker(String password, boolean availability, int failurePasswordAttempts, String Alias , int passPasswordAttempts ) {
        Locker locker = new Locker();
        locker.password = password;
        locker.availability = availability;
        locker.failurePasswordAttempts = failurePasswordAttempts;
        locker.alias = Alias; 
        locker.passPasswordAttempts = passPasswordAttempts;
        return lockerRepository.save(locker);
    }
    @Override
    public Locker Get(int lockerNumber) {
        return lockerRepository.findLockerByLockerNumber(lockerNumber);
    }
    @Override
    public Locker updateAvailable(int lockerNumber) {
       Locker lockerWantToBook = lockerRepository.findLockerByLockerNumber(lockerNumber);
       lockerWantToBook.setAvailability(false);
       return lockerRepository.save(lockerWantToBook);
    }
    @Override
    public Locker updateAfterPassAttempt(int lockerNumber,boolean availability,int passPasswordCount) {
        Locker lockerUpdatePassAttempt = lockerRepository.findLockerByLockerNumberAndAvailability(lockerNumber, availability);
        lockerUpdatePassAttempt.setpassPasswordAttempts(passPasswordCount);
        return lockerRepository.save(lockerUpdatePassAttempt);
    }
    @Override
    public boolean existsById(int lockerNumber) {
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }
    @Override
    public Locker updateAfterPassAttempt0(int lockerNumber) {
        Locker lockerUpdatePassAttempt0 = lockerRepository.findLockerByLockerNumber(lockerNumber);
        lockerUpdatePassAttempt0.setPassword("");
        lockerUpdatePassAttempt0.setAvailability(true);
        return lockerRepository.save(lockerUpdatePassAttempt0);
    }

    @Override
    public Locker updateAfterFailAttempt(int lockerNumber,boolean availability,int failPasswordCount) {
        Locker lockerUpdateFailAttempt = lockerRepository.findLockerByLockerNumberAndAvailability(lockerNumber, availability);
        lockerUpdateFailAttempt.setfailurePasswordAttempts(failPasswordCount);
        return lockerRepository.save(lockerUpdateFailAttempt);
    }

    @Override
    public Locker updateAfterFailAttempt0(int lockerNumber) {
        Locker lockerUpdateFailAttemt0 = lockerRepository.findLockerByLockerNumber(lockerNumber);
        lockerUpdateFailAttemt0.setPassword("");
        lockerUpdateFailAttemt0.setAvailability(true);
        return lockerRepository.save(lockerUpdateFailAttemt0);
    }
    
}
