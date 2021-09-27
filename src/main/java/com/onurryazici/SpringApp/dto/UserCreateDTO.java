package com.onurryazici.SpringApp.dto;

import com.onurryazici.SpringApp.validator.UniqueUserName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserCreateDTO {
    @NotNull(message = "{backend.constraints.username.NotNull.message}")
    @Size(min = 4,max = 24,message = "{backend.constraints.username.Size.message}")
    @UniqueUserName
    private String username;

    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 2,max = 24,message = "{backend.constraints.username.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastname.NotNull.message}")
    @Size(min = 3,max = 24,message = "{backend.constraints.username.Size.message}")
    private String lastName;
}
