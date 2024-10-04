package lt.ca.javau10.controllers;

//src/main/java/lt/ca/javau10/controller/AuthController.java


import lt.ca.javau10.models.User;
import lt.ca.javau10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

 @Autowired
 private UserService userService;

 @PostMapping("/register")
 public ResponseEntity<String> register(@RequestBody User user) {
     userService.registerUser(user);
     return ResponseEntity.ok("User registered successfully!");
 }
}
