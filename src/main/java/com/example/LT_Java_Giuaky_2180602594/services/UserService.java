package com.example.LT_Java_Giuaky_2180602594.services;


import com.example.LT_Java_Giuaky_2180602594.entity.User;
import com.example.LT_Java_Giuaky_2180602594.repository.IUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public void save(@Valid User user){
        userRepository.save(user);
    }
}
