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
		if(list != null) {
			List<CategoryModel> listAll = list.stream()
					.map(s -> new CategoryModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}
	
	public List<CategoryModel> listAllByDesc() {
		List<Category> list = repo.listAllByDesc();
		if(list != null) {
			List<CategoryModel> listAll = list.stream()
					.map(s -> new CategoryModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}

	@Override
	public CategoryModel findOne(int id) {
		Category t = repo.findOne(id);
		if(t != null) {
			CategoryModel a = new CategoryModel(t);
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
		CategoryModel a = findOne(id);
		if(a != null) {
			a.setStatus_category(false);
			update(a);
		}
		
		
	}

	
}
