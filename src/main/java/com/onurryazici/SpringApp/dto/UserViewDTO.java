package com.onurryazici.SpringApp.dto;

import com.onurryazici.SpringApp.model.User;
import lombok.Getter;

import java.io.Serializable;
// // Gösterilecek verileri kısıtlamak için
@Getter
public final class UserViewDTO implements Serializable {
   private static final long serialVerionUID = 1L;

   private final String firstName;
   private final String lastName;

    private UserViewDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserViewDTO of(User user){
        return new UserViewDTO(user.getFirstName(),user.getLastName());
    }
}
