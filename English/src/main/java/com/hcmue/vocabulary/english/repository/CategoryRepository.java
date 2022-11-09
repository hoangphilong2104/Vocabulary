package com.hcmue.vocabulary.english.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcmue.vocabulary.english.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
	
}
