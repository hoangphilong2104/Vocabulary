package com.hcmue.vocabulary.english.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.VocabularyType;

@Repository
public interface VocabularyTypeRepository extends JpaRepository<VocabularyType,Integer>{
	
}
