package com.example.cokunbe.controller;

import com.example.cokunbe.dto.GetLetterResponseDto;
import com.example.cokunbe.entity.Letter;
import com.example.cokunbe.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class LetterController {

    private final LetterService letterService;

    @Autowired
    public LetterController(LetterService letterService) {
        this.letterService = letterService;
    }

    @GetMapping("/letters/add")
    public String beforeRegisterLetter(){
        return "";
    }

    @PostMapping("/letters/add")
    public String afterRegisterLetter(@ModelAttribute GetLetterResponseDto newLetter) {
        Letter letter = new Letter();
        letter.setTitle(newLetter.getTitle());
        letter.setAuthor(newLetter.getAuthor());
        letter.setDate(LocalDate.now());
        letter.setContent(newLetter.getContent());
        letter.setImage(newLetter.getImage());
        letterService.join(letter);
        return "redirect:";
    }

    @GetMapping("/letters")
    public String getLetterList(Model model) {
        List<Letter> letters = letterService.findLetters();
        model.addAttribute("letters", letters);
        return "";
    }

    @GetMapping("/letters/{letterId}")
    public String getLetter(@PathVariable Integer letterId, Model model) {
        Optional<Letter> letter = letterService.getLetterById(letterId);
        if (letter.isPresent()) {
            model.addAttribute("letter", letter.get());
            return "";
        } else {
            return "letter-not-found";
        }
    }

}
