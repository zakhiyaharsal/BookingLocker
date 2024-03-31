package demo.bookinglocker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.bookinglocker.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findUserByEmail(String email);
    List <User> findListUserByEmail(String email);
    List <User> findListUserById(int Id);
}
