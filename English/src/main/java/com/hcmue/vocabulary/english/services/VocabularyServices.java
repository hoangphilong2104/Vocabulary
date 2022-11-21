package com.hcmue.vocabulary.english.services;

import java.util.ArrayList;
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
		if(list != null) {
			List<VocabularyModel> listAll = list.stream()
					.map(s -> new VocabularyModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}
	
	public List<VocabularyModel> listAllByDesc() {
		List<Vocabulary> list = repo.listAllByDesc();
		if(list != null) {
			List<VocabularyModel> listAll = list.stream()
					.map(s -> new VocabularyModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}
	
	@Override
	public VocabularyModel findOne(int id) {
		Vocabulary t = repo.findOne(id);
		if(t != null) {
			VocabularyModel a = new VocabularyModel(t);
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
		Vocabulary a = repo.findOne(id);
		if(a != null) {
			VocabularyModel t = new VocabularyModel(a);
			t.setStatus_vocabulary(false);
			update(t);
		}
		
		
	}

	public int getRownum() {
		return repo.getRownum();
	}

	public VocabularyModel findOne(String q) {
		if(repo.findOne(q) != null) {
			VocabularyModel a = new VocabularyModel(repo.findOne(q));
			return a;
		}
		return null;
	}
	
	public List<String> listSuggestions(){
		List<String> suggestions = new ArrayList<String>();
		List<VocabularyModel> listAll = listAll();
		if(listAll != null) {
			for(int i=0;i<listAll.size();i++) {
				suggestions.add(listAll.get(i).getSpelling().toLowerCase());
			}
			return suggestions;
		}
		return null;
	}
	
}
