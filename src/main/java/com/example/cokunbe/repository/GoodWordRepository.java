package com.example.cokunbe.repository;

import com.example.cokunbe.entity.GoodWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GoodWordRepository extends JpaRepository<GoodWord, Integer> {
    @Query(value = "SELECT * FROM good_word ORDER BY RAND() limit 2", nativeQuery = true)
    ArrayList<GoodWord> getTwoWords();
}
