package com.hcmue.vocabulary.english.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.model.ItemDetailModel;
import com.hcmue.vocabulary.english.model.VocabularyDetailModel;
import com.hcmue.vocabulary.english.model.VocabularyModel;
import com.hcmue.vocabulary.english.model.VocabularyTypeModel;

@Service
public class ItemDetailServices implements Services<ItemDetailModel>{
	
	@Autowired
	private VocabularyServices vocabularyServices;
	@Autowired
	private VocabularyTypeServices vocabularyTypeServices;
	@Autowired
	private VocabularyDetailServices vocabularyDetailServices;
	
	@Override
	public List<ItemDetailModel> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDetailModel findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ItemDetailModel t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public List<ItemDetailModel> listById(int id){
		VocabularyModel voca = vocabularyServices.findOne(id);
		if(voca != null) {
			List<VocabularyTypeModel> listVocaTypeModel = vocabularyTypeServices.listById(voca.getId_vocabulary());
			if(listVocaTypeModel != null) {
				List<ItemDetailModel> list = new ArrayList<ItemDetailModel>();
				for(int i = 0;i < listVocaTypeModel.size();i++) {
					ItemDetailModel temp = new ItemDetailModel();
					VocabularyDetailModel vocaDetail = vocabularyDetailServices.findOne(listVocaTypeModel.get(i).getId_vocabulary_type());
					if(vocaDetail != null) {
						temp = trans(temp,listVocaTypeModel.get(i));
						temp = trans(temp,vocaDetail);
						list.add(temp);
					}
				}
				return list;
			}
		}
		return null;
	}
	
	public ItemDetailModel trans(ItemDetailModel a, VocabularyTypeModel b) {
		a.setId_vocabulary_type(b.getId_vocabulary_type());
		a.setType_detail(b.getType());
		return a;
	}
	
	public ItemDetailModel trans(ItemDetailModel a, VocabularyDetailModel b) {
		a.setExample_detail(b.getExample());
		a.setId_vocabulary_detail(b.getId_vocabulary_detail());
		a.setMean(b.getMean());
		return a;
	}
	
}
