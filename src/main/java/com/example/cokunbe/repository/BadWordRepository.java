package com.example.cokunbe.repository;

import com.example.cokunbe.entity.BadWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BadWordRepository extends JpaRepository<BadWord, Integer> {
    @Query(value = "SELECT * FROM bad_word ORDER BY RAND() limit 2", nativeQuery = true)
    ArrayList<BadWord> getTwoWords();
}
