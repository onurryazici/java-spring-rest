package com.onurryazici.SpringApp.api;

import com.onurryazici.SpringApp.dto.UserCreateDTO;
import com.onurryazici.SpringApp.dto.UserViewDTO;
import com.onurryazici.SpringApp.service.UserService;
import com.onurryazici.SpringApp.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;


    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){
        final UserViewDTO user = userService.getUserById(id);
        return  ResponseEntity.ok(user);
    }

    @PostMapping("v1/addUser")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User succesfully created"));
    }
}
