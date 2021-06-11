package com.springboot_mongodb.SpringBoot.MongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String userId){
        return userRepository.findById(userId);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public Optional<User> updateUser(String userId,User user){
        Optional<User> findUser=userRepository.findById(userId);
        findUser.ifPresent(user1->user1.setFirstName(user.getFirstName()));
        findUser.ifPresent(user1->user1.setLastName(user.getLastName()));
        findUser.ifPresent(user1->user1.setEmail(user.getEmail()));
        findUser.ifPresent(user1->user1.setGender(user.getGender()));
        findUser.ifPresent(user1->userRepository.save(user1));
        return findUser;
    }

    public Optional<User> deleteUser(String userId){

        Optional<User> findUser=userRepository.findById(userId);
        findUser.ifPresent(user->userRepository.delete(user));
        return findUser;
    }

}
