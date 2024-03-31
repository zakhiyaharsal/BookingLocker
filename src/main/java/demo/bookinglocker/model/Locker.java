package demo.bookinglocker.model;

import javax.persistence.*;

@Entity
@Table(name = "Lockers")
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Locker_Number", nullable = false)
    private int lockerNumber;

    @Column(name = "Password", nullable = false)
    public String password;

    @Column(name = "Availability", columnDefinition = "boolean default false")
    public boolean availability;

    @Column(name = "Failure_Password_Attempts")
    public int failurePasswordAttempts;

    @Column(name = "Alias")
    public String alias;

    @Column(name = "Pass_Password_Attempts")
    public int passPasswordAttempts;


    public int getLockerNumber() {
        return this.lockerNumber;
    }

    public void setLockerNumber(int lockerNumber) {
        this.lockerNumber = lockerNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAvailability() {
        return this.availability;
    }

    public boolean getAvailability() {
        return this.availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getfailurePasswordAttempts() {
        return this.failurePasswordAttempts;
    }

    public void setfailurePasswordAttempts(int failurePasswordAttempts) {
        this.failurePasswordAttempts = failurePasswordAttempts;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getpassPasswordAttempts() {
        return this.passPasswordAttempts;
    }

    public void setpassPasswordAttempts(int passPasswordAttempts) {
        this.passPasswordAttempts = passPasswordAttempts;
    }

}