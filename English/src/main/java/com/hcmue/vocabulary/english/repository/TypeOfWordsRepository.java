package com.hcmue.vocabulary.english.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.TypeOfWords;

@Repository
public interface TypeOfWordsRepository extends JpaRepository<TypeOfWords,Integer>{
	@Query("SELECT a FROM TypeOfWords a WHERE a.id_type_of_words = ?1")
	public TypeOfWords findOne(int id);
}
