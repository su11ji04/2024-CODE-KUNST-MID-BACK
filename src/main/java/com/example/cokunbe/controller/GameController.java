package com.example.cokunbe.controller;

import com.example.cokunbe.dto.GetWordsResponseDto;
import com.example.cokunbe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/game/words")
    public ResponseEntity<?> getGameWords() {
        GetWordsResponseDto getWordsResponseDto = gameService.getGameWords();
        return (getWordsResponseDto != null)?
                ResponseEntity.status(HttpStatus.OK).body(getWordsResponseDto):
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("단어 생성에 실패했습니다.");
    }
}
