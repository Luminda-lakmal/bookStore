package com.example.demo.controller;

import com.example.demo.db.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/get")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/add")
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }
    @DeleteMapping(path = {"/{id}"})
    public User deleteUser(@PathVariable("id") int id){
        User user = userRepository.getOne(id);
        userRepository.deleteById(id);
        return user;
    }

}
