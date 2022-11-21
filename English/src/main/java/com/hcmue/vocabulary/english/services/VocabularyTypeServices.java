package com.hcmue.vocabulary.english.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.entity.VocabularyType;
import com.hcmue.vocabulary.english.model.VocabularyTypeModel;
import com.hcmue.vocabulary.english.repository.VocabularyRepository;
import com.hcmue.vocabulary.english.repository.VocabularyTypeRepository;


@Service
public class VocabularyTypeServices implements Services<VocabularyTypeModel>{
	
	@Autowired
	private VocabularyTypeRepository repo;
	
	@Autowired
	private VocabularyRepository vocaRepo;
	
	@Override
	public List<VocabularyTypeModel> listAll() {
		List<VocabularyType> list = repo.findAll();
		if(list != null) {
			List<VocabularyTypeModel> listAll = list.stream()
					.map(s -> new VocabularyTypeModel(s))
					.collect(Collectors.toList());
			for(int i=0;i<listAll.size();i++) {
				listAll.get(i).setVocabulary(vocaRepo.findOne(listAll.get(i).getId_vocabulary()).getSpelling());
			}
			return listAll;
		}
		return null;
	}
	
	public List<VocabularyTypeModel> listAllByDesc() {
		List<VocabularyType> list = repo.listAllByDesc();
		if(list != null) {
			List<VocabularyTypeModel> listAll = list.stream()
					.map(s -> new VocabularyTypeModel(s))
					.collect(Collectors.toList());
			for(int i=0;i<listAll.size();i++) {
				listAll.get(i).setVocabulary(vocaRepo.findOne(listAll.get(i).getId_vocabulary()).getSpelling());
			}
			return listAll;
		}
		return null;
	}
	
	@Override
	public VocabularyTypeModel findOne(int id) {
		VocabularyType t = repo.findOne(id);
		if(t != null) {
			VocabularyTypeModel a = new VocabularyTypeModel(t);
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
		VocabularyType a = repo.findOne(id);
		if(a != null) {
			VocabularyTypeModel t = new VocabularyTypeModel(a);
			t.setStatus_vocabulary_type(false);
			update(t);
		}
	}

	public List<VocabularyTypeModel> listById(int id) {
		List<VocabularyType> list = repo.listById(id);
		if(list != null) {
			List<VocabularyTypeModel> listAll = list.stream()
					.map(s -> new VocabularyTypeModel(s))
					.collect(Collectors.toList());
			return listAll;
		}
		return null;
	}
	
	public VocabularyTypeModel findOne_FK(int id) {
		List<VocabularyTypeModel> list = listById(id);
		if(list != null) {
			return list.get(0);
		}
		return null;
	}
	
}
