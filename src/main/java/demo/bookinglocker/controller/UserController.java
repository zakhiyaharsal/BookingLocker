package demo.bookinglocker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import demo.bookinglocker.model.User;
import demo.bookinglocker.repository.UserRepository;
import demo.bookinglocker.service.UserService;
import demo.bookinglocker.utilities.responsehandler;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepo;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user, BindingResult result) {
      
        String email = user.getEmail();
       try {
            List<User> existUserEmail = userRepo.findListUserByEmail(email);
            if (existUserEmail.isEmpty()||existUserEmail.size()==0) {
                userService.addUser(user);
                LOGGER.info("Process register untuk menambah user");
                String Pesan = "Pendaftaran user berhasil";
                User registeredUserEmail = userRepo.findUserByEmail(email);
                return responsehandler.generateResponse(Pesan,HttpStatus.OK, registeredUserEmail);
            } else {
                String Pesan = "Email Sudah terdaftar";
                LOGGER.info("Block pendaftaran user karena email sudah terdaftar");
                return responsehandler.generateResponse(Pesan,HttpStatus.OK, null);
            }
        } catch (Exception e) {
        return responsehandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS, null);
       }
    }

}