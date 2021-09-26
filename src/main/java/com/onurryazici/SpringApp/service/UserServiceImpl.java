package com.onurryazici.SpringApp.service;

import com.onurryazici.SpringApp.dto.UserCreateDTO;
import com.onurryazici.SpringApp.dto.UserViewDTO;
import com.onurryazici.SpringApp.exception.NotFoundException;
import com.onurryazici.SpringApp.model.User;
import com.onurryazici.SpringApp.repository.UserRepository;
import com.onurryazici.SpringApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserViewDTO getUserById(Long id) {
        final User user = userRepository.findById(id).orElseThrow(()->new NotFoundException("Not found exception"));
        return UserViewDTO.of(user);
    }

    @Override
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository.save(new User(userCreateDTO.getFirstName(),userCreateDTO.getLastName()));
        return UserViewDTO.of(user);
    }

    @Override
    public List<UserViewDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }
}
