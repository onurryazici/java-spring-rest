package com.onurryazici.SpringApp.service;

import com.onurryazici.SpringApp.dto.UserCreateDTO;
import com.onurryazici.SpringApp.dto.UserUpdateDTO;
import com.onurryazici.SpringApp.dto.UserViewDTO;

import java.util.List;

public interface UserService {

    UserViewDTO getUserById(Long id);

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    List<UserViewDTO> getAllUsers();

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);
}
