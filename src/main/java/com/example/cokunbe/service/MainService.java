package com.example.cokunbe.service;

import com.example.cokunbe.dto.GetHeartResponseDto;
import com.example.cokunbe.entity.Heart;
import com.example.cokunbe.repository.HeartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    private HeartRepository heartRepository;

    public GetHeartResponseDto getHeartNum() {
        return new GetHeartResponseDto((int)heartRepository.count());
    }

    public boolean addHeart() {
        Heart heart = new Heart();
        Heart saved = heartRepository.save(heart);
        return (saved != null)? true:false;
    }
}
