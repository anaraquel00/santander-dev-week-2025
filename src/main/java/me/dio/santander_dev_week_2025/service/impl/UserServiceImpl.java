package me.dio.santander_dev_week_2025.service.impl;

import me.dio.santander_dev_week_2025.domain.model.User;
import me.dio.santander_dev_week_2025.repository.UserRepository;
import me.dio.santander_dev_week_2025.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This account is already exist.");
        }
return userRepository.save(userToCreate);
    }
}
