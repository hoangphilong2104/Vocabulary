package com.hcmue.vocabulary.english.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.entity.Category;
import com.hcmue.vocabulary.english.model.CategoryModel;
import com.hcmue.vocabulary.english.repository.CategoryRepository;


@Service
public class CategoryServices implements Services<CategoryModel>{
	
	@Autowired
	private CategoryRepository repo;
	
	@Override
	public List<CategoryModel> listAll() {
		List<Category> list = repo.findAll();
		List<CategoryModel> listAll = list.stream()
				.map(s -> new CategoryModel(s))
				.collect(Collectors.toList());
		return listAll;
	}

	@Override
	public CategoryModel findOne(int id) {
		if(repo.getOne(id) != null) {
			CategoryModel a = new CategoryModel(repo.getOne(id));
			return a;
		}
		return null;
	}

	@Override
	public void update(CategoryModel t) {
		if(t != null) {
			Category a = new Category(t);
			repo.save(a);
		}
	}

	@Override
	public void delete(int id) {
		Category a = repo.getOne(id);
		if(a != null) {
			CategoryModel t = new CategoryModel(a);
			t.setStatus_category(false);
			update(t);
		}
		
		
	}

	
}
