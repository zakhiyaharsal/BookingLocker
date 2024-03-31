package demo.bookinglocker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.bookinglocker.model.User;
import demo.bookinglocker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        // Save user to the database
        userRepository.save(user);
    }
    
}
