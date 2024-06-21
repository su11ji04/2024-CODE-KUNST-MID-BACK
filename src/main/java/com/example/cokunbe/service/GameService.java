package com.example.cokunbe.service;

import com.example.cokunbe.dto.GetWordsResponseDto;
import com.example.cokunbe.entity.BadWord;
import com.example.cokunbe.entity.GoodWord;
import com.example.cokunbe.repository.BadWordRepository;
import com.example.cokunbe.repository.GoodWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {
    @Autowired
    private GoodWordRepository goodWordRepository;
    @Autowired
    private BadWordRepository badWordRepository;

    public GetWordsResponseDto getGameWords() {
        ArrayList<String> gameWords = new ArrayList<>();

        ArrayList<GoodWord> goodWords = goodWordRepository.getTwoWords();
        ArrayList<BadWord> badWords = badWordRepository.getTwoWords();
        for (GoodWord goodWord : goodWords) gameWords.add(goodWord.getWord());
        for (BadWord badWord : badWords) gameWords.add(badWord.getWord());

        return new GetWordsResponseDto(gameWords);
    }
}
