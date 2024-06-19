package com.example.LT_Java_Giuaky_2180602594.services;

import com.example.LT_Java_Giuaky_2180602594.entity.Nhanvien;
import com.example.LT_Java_Giuaky_2180602594.repository.INhanvienRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NhanvienService {
    @Autowired
    private INhanvienRepository nhanvienRepository;

    public Nhanvien getNhanvienById(Long id){
        return nhanvienRepository.findById(id).orElse(null);
    }

    public void addNhanvien(Nhanvien nhanvien){
        nhanvienRepository.save(nhanvien);
    }

    public List<Nhanvien> getAllNhanviens(){
        return nhanvienRepository.findAll();
    }

    public void deleteNhanvien(Long id){
        nhanvienRepository.deleteById(id);
    }

    public void updateNhanvien(@NotNull Nhanvien nhanvien){
        if (nhanvien == null || nhanvien.getId() == null) {
            throw new IllegalArgumentException("Invalid nhanvien object");
        }

        Nhanvien existingBook = getNhanvienById(nhanvien.getId());


        existingBook.setManv(nhanvien.getManv());
        existingBook.setTen(nhanvien.getTen());
        existingBook.setGioitinh(nhanvien.getGioitinh());
        existingBook.setNoisinh(nhanvien.getNoisinh());
        existingBook.setLuong(nhanvien.getLuong());
        existingBook.setPhongban(nhanvien.getPhongban());


        nhanvienRepository.save(existingBook);
    }


}