package com.onurryazici.SpringApp.service;

import com.onurryazici.SpringApp.dto.UserCreateDTO;
import com.onurryazici.SpringApp.dto.UserUpdateDTO;
import com.onurryazici.SpringApp.dto.UserViewDTO;
import com.onurryazici.SpringApp.exception.NotFoundException;
import com.onurryazici.SpringApp.model.User;
import com.onurryazici.SpringApp.repository.UserRepository;
import com.onurryazici.SpringApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user= userRepository.findById(id).orElseThrow( ()->new NotFoundException("This user does not exits"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        final User updatedUser = userRepository.save(user);
        return UserViewDTO.of(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        final User user = userRepository.findById(id).orElseThrow(()->new NotFoundException(("There is no such user")));
        userRepository.deleteById(user.getId());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> pagination(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
    }
}
