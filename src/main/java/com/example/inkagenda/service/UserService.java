package com.example.inkagenda.service;

import com.example.inkagenda.exceptions.BadRequestException;
import com.example.inkagenda.model.User;
import com.example.inkagenda.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRespository;

    public List<User> getAllUser() {
        return userRespository.findAll();
    }

    public User findByIdOrThrowBadRequestException(long id) {

        return userRespository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

    public User save(User user) {
        return userRespository.save(user);
    }

    public void delete(Long id) {
        userRespository.delete(findByIdOrThrowBadRequestException(id));
    }


}

