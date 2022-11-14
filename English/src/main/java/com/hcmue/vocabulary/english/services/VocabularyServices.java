package com.hcmue.vocabulary.english.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.entity.Vocabulary;
import com.hcmue.vocabulary.english.model.VocabularyModel;
import com.hcmue.vocabulary.english.repository.VocabularyRepository;


@Service
public class VocabularyServices implements Services<VocabularyModel>{
	
	@Autowired
	private VocabularyRepository repo;
	
	@Override
	public List<VocabularyModel> listAll() {
		List<Vocabulary> list = repo.findAll();
		List<VocabularyModel> listAll = list.stream()
				.map(s -> new VocabularyModel(s))
				.collect(Collectors.toList());
		return listAll;
	}

	@Override
	public VocabularyModel findOne(int id) {
		if(repo.getOne(id) != null) {
			VocabularyModel a = new VocabularyModel(repo.getOne(id));
			return a;
		}
		return null;
	}

	@Override
	public void update(VocabularyModel t) {
		if(t != null) {
			Vocabulary a = new Vocabulary(t);
			repo.save(a);
		}
	}

	@Override
	public void delete(int id) {
		Vocabulary a = repo.getOne(id);
		if(a != null) {
			VocabularyModel t = new VocabularyModel(a);
			t.setStatus_vocabulary(false);
			update(t);
		}
		
		
	}

	public int getRownum() {
		return repo.getRownum();
	}
}
