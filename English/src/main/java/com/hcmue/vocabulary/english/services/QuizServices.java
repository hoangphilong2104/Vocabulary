package com.hcmue.vocabulary.english.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmue.vocabulary.english.model.QuestionModel;
import com.hcmue.vocabulary.english.model.VocabularyDetailModel;
import com.hcmue.vocabulary.english.model.VocabularyModel;
import com.hcmue.vocabulary.english.model.VocabularyTypeModel;

@Service
public class QuizServices {
	@Autowired
	private VocabularyServices vocabularyServices;
	@Autowired
	private VocabularyTypeServices vocabularyTypeServices;
	@Autowired
	private VocabularyDetailServices vocabularyDetailServices;
	
	public List<QuestionModel> listAll(){
		List<QuestionModel> list = new ArrayList<QuestionModel>();
		int total = vocabularyServices.getRownum();
		//Number Quiz
		int constNumQuiz = 5;
		if(total < 5) {constNumQuiz = total;}
		
		int numQuiz[] = new int[constNumQuiz];
		for(int i=0;i<constNumQuiz;i++) {
			int temp = (int) Math.floor(Math.random() * (total - 1)) + 1;
			if(i != 0) {
				for(int j=0;j<i;j++) {
					if(numQuiz[j] == temp) {
						i--;
						break;
					}else {
						if(i == j+1) {
							numQuiz[i] = temp;
							break;
						}
					}
				}
			}else {
				numQuiz[i] = temp;
			}
		}
		for(int i=0;i<constNumQuiz;i++) {
			QuestionModel a = new QuestionModel();
			a.setNumb(i+1);
			VocabularyModel voca = vocabularyServices.findOne(numQuiz[i]);
			VocabularyTypeModel type = vocabularyTypeServices.findOne_FK(voca.getId_vocabulary());
			VocabularyDetailModel detail = vocabularyDetailServices.findOne(type.getId_vocabulary_type());
			a.setAnswer(detail.getMean());
			a.setQuestion(voca.getSpelling());
			
			//List Answer relative
			List<VocabularyTypeModel> listType = vocabularyTypeServices.listById(voca.getId_vocabulary());
			int numAnswer[] = new int[listType.size()];
			for(int j=0;j<listType.size();j++) {
				VocabularyDetailModel tempDetail = vocabularyDetailServices.findOne(listType.get(j).getId_vocabulary_type());
				numAnswer[j] = tempDetail.getId_vocabulary_detail();
			}
			List<String> options = new ArrayList<String>();
			int totalDetail = vocabularyDetailServices.getRownum();
			int numDetail[] = new int[4];
			//4 Answer
			for(int j=0;j<numDetail.length;j++) {
				int temp = (int) Math.floor(Math.random() * (totalDetail - 1)) + 1;
				boolean statusLoop = true;
				for(int k=0;k<numAnswer.length;k++) {
					if(temp == numAnswer[k]) {
						j--;
						statusLoop = false;
						break;
					}
				}
				if(statusLoop == true) {
					if(j != 0) {
						for(int k=0;k<j;k++) {
							if(numDetail[k] == temp) {
								j--;
								statusLoop = false;
								break;
							}else {
								if(j == k+1) {
									numDetail[j] = temp;
									break;
								}
							}
						}
					}else {
						numDetail[j] = temp;
					}
				}
				if(statusLoop == true) {
					VocabularyDetailModel detailTemp = vocabularyDetailServices.findOneDetail(numDetail[j]);
					options.add(detailTemp.getMean());
				}
			}
			int temp = (int) Math.floor(Math.random() * 4);
			options.set(temp, detail.getMean());
			a.setOptions(options);
			list.add(a);
		}
		
		return list;
	}
	
	public List<QuestionModel> listAllVietName(){
		List<QuestionModel> list = new ArrayList<QuestionModel>();
		int total = vocabularyServices.getRownum();
		//Number Quiz
		int constNumQuiz = 5;
		if(total < 5) {constNumQuiz = total;}
		
		int numQuiz[] = new int[constNumQuiz];
		for(int i=0;i<constNumQuiz;i++) {
			int temp = (int) Math.floor(Math.random() * (total - 1)) + 1;
			if(i != 0) {
				for(int j=0;j<i;j++) {
					if(numQuiz[j] == temp) {
						i--;
						break;
					}else {
						if(i == j+1) {
							numQuiz[i] = temp;
							break;
						}
					}
				}
			}else {
				numQuiz[i] = temp;
			}
		}
		for(int i=0;i<constNumQuiz;i++) {
			QuestionModel a = new QuestionModel();
			a.setNumb(i+1);
			VocabularyModel voca = vocabularyServices.findOne(numQuiz[i]);
			VocabularyTypeModel type = vocabularyTypeServices.findOne_FK(voca.getId_vocabulary());
			VocabularyDetailModel detail = vocabularyDetailServices.findOne(type.getId_vocabulary_type());
			a.setAnswer(voca.getSpelling());
			a.setQuestion(detail.getMean());
			
			List<String> options = new ArrayList<String>();
			int numVoca[] = new int[4];
			//4 Answer
			for(int j=0;j<numVoca.length;j++) {
				int temp = (int) Math.floor(Math.random() * (total - 1)) + 1;
				boolean statusLoop = true;
				if(j != 0) {
					for(int k=0;k<j;k++) {
						if(numVoca[k] == temp) {
							j--;
							statusLoop = false;
							break;
						}else {
							if(j == k+1) {
								numVoca[j] = temp;
								break;
							}
						}
					}
				}else {
					numVoca[j] = temp;
				}
				if(statusLoop == true) {
					if(numVoca[j] != numQuiz[i]) {
						VocabularyModel vocaTemp = vocabularyServices.findOne(numVoca[j]);
						options.add(vocaTemp.getSpelling());
					}else {
						j--;
					}
				}
			}
			int temp = (int) Math.floor(Math.random() * 4);
			options.set(temp, voca.getSpelling());
			a.setOptions(options);
			list.add(a);
		}
		
		return list;
	}
}
