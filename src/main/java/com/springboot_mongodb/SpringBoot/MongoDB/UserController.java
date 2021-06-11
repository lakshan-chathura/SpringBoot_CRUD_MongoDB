package com.springboot_mongodb.SpringBoot.MongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/getAllUsers/{userId}")
    public Optional<User> getBookId(@PathVariable("userId") String userId ){
        return userService.getUserById(userId);
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return "User Saved Successfully";
    }

    @PutMapping("/updateUser/{userId}")
    public Optional<User> updateUser(@PathVariable("userId") String userId, @RequestBody User user){
        return userService.updateUser(userId,user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public Optional<User> deleteUserById(@PathVariable("userId") String userId ){
        return userService.deleteUser(userId);
    }

}
