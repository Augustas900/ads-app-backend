package lt.ca.javau10.services;

//src/main/java/lt/ca/javau10/service/UserService.java


import lt.ca.javau10.models.User;
import lt.ca.javau10.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

 @Autowired
 private UserRepository userRepository;

 @Autowired
 private PasswordEncoder passwordEncoder;

 public void registerUser(User user) {
     // Encode password before saving
     user.setPassword(passwordEncoder.encode(user.getPassword()));
     userRepository.save(user);
 }
}
