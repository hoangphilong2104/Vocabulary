package com.hcmue.vocabulary.english.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.entity.VocabularyDetail;
import com.hcmue.vocabulary.english.model.VocabularyDetailModel;
import com.hcmue.vocabulary.english.repository.VocabularyDetailRepository;


@Service
public class VocabularyDetailServices implements Services<VocabularyDetailModel>{
	
	@Autowired
	private VocabularyDetailRepository repo;
	
	@Override
	public List<VocabularyDetailModel> listAll() {
		List<VocabularyDetail> list = repo.findAll();
		List<VocabularyDetailModel> listAll = list.stream()
				.map(s -> new VocabularyDetailModel(s))
				.collect(Collectors.toList());
		return listAll;
	}

	@Override
	public VocabularyDetailModel findOne(int id) {
		if(repo.getOne(id) != null) {
			VocabularyDetailModel a = new VocabularyDetailModel(repo.getOne(id));
			return a;
		}
		return null;
	}

	@Override
	public void update(VocabularyDetailModel t) {
		if(t != null) {
			VocabularyDetail a = new VocabularyDetail(t);
			repo.save(a);
		}
	}

	@Override
	public void delete(int id) {
		VocabularyDetail a = repo.getOne(id);
		if(a != null) {
			VocabularyDetailModel t = new VocabularyDetailModel(a);
			t.setStatus_vocabulary_detail(false);
			update(t);
		}
		
	}

	
}
