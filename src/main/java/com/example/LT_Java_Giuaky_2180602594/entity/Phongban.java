package com.example.LT_Java_Giuaky_2180602594.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor


@Data
@Entity
@Table(name = "phongban")
public class Phongban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "maphong", length = 50)
    @NotEmpty(message = "Maphong must not be null")
    @NotNull(message = "Maphong is required")
    @Size(max = 3, min = 1, message = "Maphong must be less than 50 characters")
    private String maphong;

    @Column(name = "tenphong", length = 50)
    @NotEmpty(message = "Tenphong must not be null")
    @NotNull(message = "Tenphong is required")
    @Size(max = 30, min = 1, message = "Tenphong must be less than 50 characters")
    private String tenphong;
}
