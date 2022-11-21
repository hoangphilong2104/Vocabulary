package com.hcmue.vocabulary.english.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.VocabularyDetail;


@Repository
public interface VocabularyDetailRepository extends JpaRepository<VocabularyDetail,Integer>{
	@Query("SELECT a FROM VocabularyDetail a WHERE a.id_vocabulary_type = ?1")
	public List<VocabularyDetail> listById(int id);
	@Query("SELECT a FROM VocabularyDetail a WHERE a.id_vocabulary_type = ?1")
	public VocabularyDetail findOne(int id);
	@Query("SELECT a FROM VocabularyDetail a ORDER BY a.id_vocabulary_type desc")
	public List<VocabularyDetail> listAllByDesc();
	@Query("SELECT COUNT(id_vocabulary_detail) FROM VocabularyDetail a")
	public int getRownum();
	@Query("SELECT a FROM VocabularyDetail a WHERE a.id_vocabulary_detail = ?1")
	public VocabularyDetail findOneDetail(int id);
}
