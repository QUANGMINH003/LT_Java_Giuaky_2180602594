package com.example.LT_Java_Giuaky_2180602594.services;

import com.example.LT_Java_Giuaky_2180602594.entity.Phongban;
import com.example.LT_Java_Giuaky_2180602594.repository.IPhongbanRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongbanService {
    @Autowired
    private IPhongbanRepository phongbanRepository;

    public Phongban getPhongbanById(Long id){
        return phongbanRepository.findById(id).orElse(null);
    }

    public void addPhongban(Phongban phongban){
        phongbanRepository.save(phongban);
    }

    public List<Phongban> getAllPhongbans(){
        return phongbanRepository.findAll();
    }

    public void deletePhongban(Long id){
        phongbanRepository.deleteById(id);
    }

    public void updatePhongban(@NotNull Phongban phongban) {
        if (phongban == null || phongban.getId() == null) {
            throw new IllegalArgumentException("Invalid phongban object");
        }

        Phongban existingCategory = getPhongbanById(phongban.getId());

        existingCategory.setMaphong(phongban.getMaphong());
        existingCategory.setTenphong(phongban.getTenphong());

        phongbanRepository.save(existingCategory);
    }

}