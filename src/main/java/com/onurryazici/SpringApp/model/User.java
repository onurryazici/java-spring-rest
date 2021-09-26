package com.onurryazici.SpringApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data // Auto generate getter/setter
@NoArgsConstructor // For custom constructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Auto increment
    private Long id;

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
