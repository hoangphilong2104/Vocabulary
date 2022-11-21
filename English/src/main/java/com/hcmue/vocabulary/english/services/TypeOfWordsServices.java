package com.hcmue.vocabulary.english.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.entity.TypeOfWords;
import com.hcmue.vocabulary.english.model.TypeOfWordsModel;
import com.hcmue.vocabulary.english.repository.TypeOfWordsRepository;

@Service
public class TypeOfWordsServices implements Services<TypeOfWordsModel>{
	
	@Autowired
	private TypeOfWordsRepository repo;

	@Override
	public List<TypeOfWordsModel> listAll() {
		List<TypeOfWords> list = repo.findAll();
		if(list != null) {
			List<TypeOfWordsModel> listAll = list.stream()
					.map(s -> new TypeOfWordsModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}

	@Override
	public TypeOfWordsModel findOne(int id) {
		TypeOfWords t = repo.findOne(id);
		if(t != null) {
			TypeOfWordsModel a = new TypeOfWordsModel(t);
			return a;
		}
		return null;
	}

	@Override
	public void update(TypeOfWordsModel t) {
		if(t != null) {
			TypeOfWords a = new TypeOfWords(t);
			repo.save(a);
		}
		
	}

	@Override
	public void delete(int id) {
		TypeOfWords a = repo.findOne(id);
		if(a != null) {
			TypeOfWordsModel t = new TypeOfWordsModel(a);
			t.setStatus_type_of_words(false);
			update(t);
		}
	}
	
	
}
