package com.example.LT_Java_Giuaky_2180602594.entity;

import com.example.LT_Java_Giuaky_2180602594.validator.annotation.ValidPhongbanId;
import com.example.LT_Java_Giuaky_2180602594.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor


@Data
@Entity
@Table(name = "nhanvien")

public class Nhanvien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manv", length = 50)
    @NotEmpty(message = "Manv must not be null")
    @NotNull(message = "Manv is required")
    @Size(max = 3, min = 1, message = "Manv must be less than 50 characters")
    private String manv;

    @Column(name = "ten", length = 100)
    @NotEmpty(message = "Ten must not be null")
    @NotNull(message = "Ten is required")
    @Size(max = 100, min = 1, message = "Ten must be less than 50 characters")
    private String ten;

    @Column(name = "gioitinh", length = 50)
    @Size(max = 3, min = 1, message = "Gioitinh must be less than 50 characters")
    private String gioitinh;

    @Column(name = "noisinh", length = 100)
    @NotEmpty(message = "Noisinh must not be null")
    @Size(max = 200, min = 1, message = "Noisinh must be less than 50 characters")
    private String noisinh;

    @Column(name = "luong")
    @Positive(message = "Price must be greater than 0")
    private int luong;


    @ManyToOne
    @JoinColumn(name ="phongban_id")
    @ValidPhongbanId
    private Phongban phongban;

    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;

}
