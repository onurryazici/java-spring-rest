package com.onurryazici.SpringApp.api;

import com.onurryazici.SpringApp.dto.UserCreateDTO;
import com.onurryazici.SpringApp.dto.UserUpdateDTO;
import com.onurryazici.SpringApp.dto.UserViewDTO;
import com.onurryazici.SpringApp.service.UserService;
import com.onurryazici.SpringApp.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;

    @GetMapping("v1")
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public ResponseEntity<?> welcome(){
        return ResponseEntity.ok(new GenericResponse("Welcome to back-end side :)"));
    }
    @GetMapping("v1/getAllUsers")
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public ResponseEntity<?> getAllUsers(){
        final List<UserViewDTO> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("v1/user/{id}")
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){
        final UserViewDTO user = userService.getUserById(id);
        return  ResponseEntity.ok(user);
    }
    @PostMapping("v1/addUser")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User succesfully created"));
    }
    @PutMapping("v1/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO){
        final UserViewDTO  user = userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("v1/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User successfully deleted"));
    }

    @GetMapping("v1/user/pagination")
    public ResponseEntity<List<UserViewDTO>> pagination(Pageable pageable){
        final List<UserViewDTO> users = userService.pagination(pageable);
        return ResponseEntity.ok(users);
    }

}
