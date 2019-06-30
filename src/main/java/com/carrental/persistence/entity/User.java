package com.carrental.persistence.entity;

import com.carrental.persistence.embeddable.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationDate = LocalDateTime.now();
    private boolean active = true;

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @ManyToOne
    private Role role;

    @ManyToOne
    private Branch branch;

    public void addRole(Role role) {
        this.role = role;
    }
  
    @Embedded
    private Address address;
}