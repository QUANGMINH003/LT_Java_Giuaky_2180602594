package com.example.LT_Java_Giuaky_2180602594.repository;

import com.example.LT_Java_Giuaky_2180602594.entity.Nhanvien;
import com.example.LT_Java_Giuaky_2180602594.entity.Phongban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPhongbanRepository extends JpaRepository<Phongban, Long> {

}
