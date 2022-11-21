package com.hcmue.vocabulary.english.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.VocabularyType;

@Repository
public interface VocabularyTypeRepository extends JpaRepository<VocabularyType,Integer>{
	@Query("SELECT a FROM VocabularyType a WHERE a.id_vocabulary = ?1")
	public List<VocabularyType> listById(int id);
	
	@Query("SELECT a FROM VocabularyType a WHERE a.id_vocabulary_type = ?1")
	public VocabularyType findOne(int id);
	
	@Query("SELECT a FROM VocabularyType a ORDER BY a.id_vocabulary_type desc")
	public List<VocabularyType> listAllByDesc();
}
