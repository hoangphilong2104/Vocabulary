package com.hcmue.vocabulary.english.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.Vocabulary;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary,Integer>{
	@Query("SELECT COUNT(id_vocabulary) FROM Vocabulary a")
	public int getRownum();
}
