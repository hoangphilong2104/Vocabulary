package com.hcmue.vocabulary.english.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.entity.VocabularyType;
import com.hcmue.vocabulary.english.model.VocabularyTypeModel;
import com.hcmue.vocabulary.english.repository.VocabularyTypeRepository;


@Service
public class VocabularyTypeServices implements Services<VocabularyTypeModel>{
	
	@Autowired
	private VocabularyTypeRepository repo;
	
	@Override
	public List<VocabularyTypeModel> listAll() {
		List<VocabularyType> list = repo.findAll();
		List<VocabularyTypeModel> listAll = list.stream()
				.map(s -> new VocabularyTypeModel(s))
				.collect(Collectors.toList());
		return listAll;
	}

	@Override
	public VocabularyTypeModel findOne(int id) {
		if(repo.getOne(id) != null) {
			VocabularyTypeModel a = new VocabularyTypeModel(repo.getOne(id));
			return a;
		}
		return null;
	}

	@Override
	public void update(VocabularyTypeModel t) {
		if(t != null) {
			VocabularyType a = new VocabularyType(t);
			repo.save(a);
		}
	}

	@Override
	public void delete(int id) {
		VocabularyType a = repo.getOne(id);
		if(a != null) {
			VocabularyTypeModel t = new VocabularyTypeModel(a);
			t.setStatus_vocabulary_type(false);
			update(t);
		}
		
		
	}

	
}
