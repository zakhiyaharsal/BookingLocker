package demo.bookinglocker.service;

import org.springframework.stereotype.Component;

import demo.bookinglocker.model.User;

@Component
public interface UserService {
    void addUser(User user);   
}
