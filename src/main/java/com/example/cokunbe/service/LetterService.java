package com.example.cokunbe.service;

import com.example.cokunbe.dto.GetLetterListResponseDto;
import com.example.cokunbe.dto.GetLetterResponseDto;
import com.example.cokunbe.entity.Letter;
import com.example.cokunbe.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class LetterService {

    @Autowired
    private LetterRepository letterRepository;

    public boolean addLetter() {
        Letter letter = new Letter();
        Letter saved = letterRepository.save(letter);
        return saved != null;
    }

    public GetLetterResponseDto getLetterById(Integer id) {
        Optional<Letter> optionalLetter = letterRepository.findById(id);
        Letter letter = optionalLetter.orElseThrow(() -> new RuntimeException("팬레터 상세 조회에 실패했습니다: " + id));

        return new GetLetterResponseDto(
                letter.getId(),
                letter.getTitle(),
                letter.getContent(),
                letter.getAuthor(),
                letter.getDate(),
                letter.getImage()
        );
    }

    public List<GetLetterListResponseDto> getAllLetter() {
        List<Letter> letters = letterRepository.findAll();

        return letters.stream()
                .map(letter -> new GetLetterListResponseDto(
                        letter.getTitle(),
                        letter.getAuthor(),
                        letter.getDate()
                ))
                .collect(Collectors.toList());
    }
}