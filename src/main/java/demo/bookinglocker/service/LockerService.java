package demo.bookinglocker.service;

import org.springframework.stereotype.Component;

import demo.bookinglocker.model.Locker;

@Component
public interface LockerService {
    void addLocker(int lockerNumber);

    Locker addLocker(String password, boolean availability,int FailurePasswordAttempts, String LockerAlias,int PassPasswordAttempts);

    Locker Get(int lockerNumber);
    Locker updateAvailable (int lockerNumber);
    Locker updateAfterPassAttempt (int lockerNumber,boolean availability,int passPasswordCount);
    Locker updateAfterPassAttempt0 (int lockerNumber);

    Locker updateAfterFailAttempt (int lockerNumber,boolean availability,int failPasswordCount);
    Locker updateAfterFailAttempt0 (int lockerNumber);

    boolean existsById(int lockerNumber);


    
}
