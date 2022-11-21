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
		if(list != null) {
			List<VocabularyDetailModel> listAll = list.stream()
					.map(s -> new VocabularyDetailModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}
	
	public List<VocabularyDetailModel> listAllByDesc() {
		List<VocabularyDetail> list = repo.listAllByDesc();
		if(list != null) {
			List<VocabularyDetailModel> listAll = list.stream()
					.map(s -> new VocabularyDetailModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}
	
	@Override
	public VocabularyDetailModel findOne(int id) {
		VocabularyDetail t = repo.findOne(id);
		if(t != null) {
			VocabularyDetailModel a = new VocabularyDetailModel(t);
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
		VocabularyDetail a = repo.findOne(id);
		if(a != null) {
			VocabularyDetailModel t = new VocabularyDetailModel(a);
			t.setStatus_vocabulary_detail(false);
			update(t);
		}
		
	}
	
	public List<VocabularyDetailModel> listById(int id) {
		List<VocabularyDetail> list = repo.listById(id);
		if(list != null) {
			List<VocabularyDetailModel> listAll = list.stream()
					.map(s -> new VocabularyDetailModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}

	public int getRownum() {
		return repo.getRownum();
	}

	public VocabularyDetailModel findOneDetail(int id) {
		VocabularyDetail t = repo.findOneDetail(id);
		if(t != null) {
			VocabularyDetailModel a = new VocabularyDetailModel(t);
			return a;
		}
		return null;
	}
	
}
