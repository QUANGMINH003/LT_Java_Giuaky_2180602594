package com.example.LT_Java_Giuaky_2180602594.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Username is required")
    @Size(max = 50, message = "Username must be less than 50 characters")
    private String username;

    @Column(name = "password", length = 250, nullable = false)
    @NotBlank(message = "Password is required")
    private String password;

    @Column(name = "email", length = 50)
    @Size(max = 50, message = "email must be less than 50 characters")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "name", length = 50, nullable = false)
    @NotBlank(message = "Your name is required")
    @Size(max = 50, message = "Your name must be less than 50 characters")
    private String fullname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Nhanvien> nhanviens = new ArrayList<>();


}
