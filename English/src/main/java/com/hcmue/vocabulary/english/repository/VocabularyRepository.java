package com.hcmue.vocabulary.english.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.Vocabulary;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary,Integer>{
	@Query("SELECT COUNT(id_vocabulary) FROM Vocabulary a")
	public int getRownum();
	
	@Query("SELECT a FROM Vocabulary a WHERE UPPER(a.spelling)=?1")
	public Vocabulary findOne(String q);
	
	@Query("SELECT a FROM Vocabulary a WHERE a.id_vocabulary = ?1")
	public Vocabulary findOne(int id);
	
	@Query("SELECT a FROM Vocabulary a ORDER BY a.id_vocabulary desc")
	public List<Vocabulary> listAllByDesc();
}
