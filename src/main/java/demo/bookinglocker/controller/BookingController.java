package demo.bookinglocker.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.bookinglocker.model.Booking;
import demo.bookinglocker.model.Locker;
import demo.bookinglocker.model.User;
import demo.bookinglocker.repository.LockerRepository;
import demo.bookinglocker.repository.UserRepository;
import demo.bookinglocker.service.BookingService;
import demo.bookinglocker.service.LockerService;
import demo.bookinglocker.utilities.responsehandler;

@RestController
@RequestMapping("/api")
public class BookingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    private BookingService bookingService;
    @Autowired
    private LockerService lockerService;
    @Autowired
    private LockerRepository lockerRepo;
    @Autowired
    private UserRepository userRepo;
   

    @PostMapping("/booking")
    public ResponseEntity<Object> addBooking(@RequestBody Booking booking, BindingResult result) {
        int lockerNumber = booking.getLockerNumber();
        int userId = booking.getUserId();
        try {
            List<User> knownUser = userRepo.findListUserById(userId);
            if (knownUser.isEmpty()|| knownUser.size()==0) {
                String Pesan = "User belum terdaftar";
                LOGGER.info("Block booking locker karena UserId: "+userId+" belum terdaftar");
                return responsehandler.generateResponse(Pesan,HttpStatus.OK, null);
            } else {
                List<Locker> availableLocker = lockerRepo.findListLockerByLockerNumber(lockerNumber);
                if (availableLocker.isEmpty()|| availableLocker.size()==0) {
                    String Pesan = "Locker Number belum terdaftar";
                    LOGGER.info("Block booking karena locker  : "+lockerNumber+" belum terdaftar");
                    return responsehandler.generateResponse(Pesan,HttpStatus.OK, null);
                } else {
                    LOGGER.info("locker : "+lockerNumber+" sudah terdaftar, cek apakah available untuk di booking ?");
                    Locker availabilityLocker = lockerService.Get(lockerNumber);
                    boolean availability = availabilityLocker.isAvailability();
                    if (availability == true) {
                        LOGGER.info("Locker : " + lockerNumber + " tersedia untuk di booking");
                        Date currentDate = new Date(System.currentTimeMillis());
                        //Masih Error saat memasukan dengan ID user yang sama untuk locker yang berbeda, 
                        //Seharusnya 1 user dapat booking maks 3 locker.
                        String Pesan="";
                        bookingService.addBooking(lockerNumber, lockerNumber, currentDate, currentDate, BigInteger.valueOf(10000), BigInteger.valueOf(0),BigInteger.valueOf(0));
                        lockerService.updateAvailable(lockerNumber);
                        LOGGER.info("Process booking Locker :" + lockerNumber + " berhasil");
                        Pesan = "Process booking Locker :" + lockerNumber + " berhasil";
                        Map<String, Object> bookinginfo = bookingService.findBookingInfo(lockerNumber); // Pass the required argument to the method
                        //}
                        return responsehandler.generateResponse(Pesan, HttpStatus.OK, bookinginfo);
                    } else {
                        String Pesan = "Locker sudah di booking";
                        LOGGER.info("Block booking Locker karena Locker: "+lockerNumber+" sudah di booking");
                        return responsehandler.generateResponse(Pesan,HttpStatus.OK, null);
                    }
                    
                }
            }
        } catch (Exception e) {
            return responsehandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS, null);
        }
    }

    
    
}
