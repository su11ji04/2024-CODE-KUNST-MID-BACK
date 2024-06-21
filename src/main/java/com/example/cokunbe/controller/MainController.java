package com.example.cokunbe.controller;

import com.example.cokunbe.dto.GetHeartResponseDto;
import com.example.cokunbe.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/main/heart")
    public ResponseEntity<?> getHeartNum() {
        GetHeartResponseDto getHeartResponseDto = mainService.getHeartNum();
        return (getHeartResponseDto != null)?
                ResponseEntity.status(HttpStatus.OK).body(getHeartResponseDto):
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("하트 개수를 불러오는 데 실패했습니다.");
    }

    @PostMapping("/main/heart/add")
    public ResponseEntity<?> addHeart() {
        boolean isAdded = mainService.addHeart();
        return (isAdded)?
                ResponseEntity.status(HttpStatus.OK).build():
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("하트를 추가하는 데 실패했습니다.");
    }
}
