package com.example.cokunbe.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetLetterResponseDto {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private LocalDate date;
    private String image;
}
