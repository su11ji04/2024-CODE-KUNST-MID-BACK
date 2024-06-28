package com.example.cokunbe.repository;

import com.example.cokunbe.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Integer> {
    Letter save(Letter letter);
    Optional<Letter> findById(Integer id);
    List<Letter> findAll();


}

