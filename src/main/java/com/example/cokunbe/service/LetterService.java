package com.example.cokunbe.service;

import com.example.cokunbe.entity.Letter;
import com.example.cokunbe.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LetterService {

    private LetterRepository letterRepository;

    public Integer join(Letter letter){
        letterRepository.save(letter);
        return letter.getId();
    }

    public List<Letter> findLetters() {
        return letterRepository.findAll();
    }

    public Optional<Letter> getLetterById(Integer letterId) {
        return letterRepository.findById(letterId);
    }

}