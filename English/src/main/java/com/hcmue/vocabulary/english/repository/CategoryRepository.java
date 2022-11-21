package com.hcmue.vocabulary.english.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
	@Query("SELECT a FROM Category a WHERE a.id_category = ?1")
	public Category findOne(int id);
	@Query("SELECT a FROM Category a ORDER BY a.id_category desc")
	public List<Category> listAllByDesc();
}
