package com.example.cokunbe.controller;

import com.example.cokunbe.dto.GetLetterListResponseDto;
import com.example.cokunbe.dto.GetLetterResponseDto;
import com.example.cokunbe.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LetterController {

    @Autowired
    private LetterService letterService;

    @GetMapping("/letters")
    public ResponseEntity<?> getLetterList() {
        List<GetLetterListResponseDto> letterList = letterService.getAllLetter();
        return (letterList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(letterList) :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("팬레터 목록 조회에 실패했습니다");
    }

    @GetMapping("/letters/{letterId}")
    public ResponseEntity<?> getLetter(@PathVariable Integer letterId) {
        GetLetterResponseDto getLetterResponseDto = letterService.getLetterById(letterId);
        return (getLetterResponseDto != null) ?
                ResponseEntity.status(HttpStatus.OK).body(getLetterResponseDto) :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("팬레터 상세 조회에 실패했습니다: " + letterId);
    }

    @PostMapping("/letters/add")
    public ResponseEntity<?> addLetter() {
        boolean isAdded = letterService.addLetter();
        return (isAdded) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("팬레터 등록에 실패했습니다");
    }
}

