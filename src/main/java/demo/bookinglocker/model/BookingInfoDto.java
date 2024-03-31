package demo.bookinglocker.model;

public class BookingInfoDto {
    private int lockerNumber;
    private int userId;
    private String password;
    private String email;

    public BookingInfoDto(int lockerNumber, int userId, String password, String email) {
        this.lockerNumber = lockerNumber;
        this.userId = userId;
        this.password = password;
        this.email = email;
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }

    public void setLockerNumber(int lockerNumber) {
        this.lockerNumber = lockerNumber;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
