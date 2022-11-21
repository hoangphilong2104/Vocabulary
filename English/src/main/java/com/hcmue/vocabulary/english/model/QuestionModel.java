package com.hcmue.vocabulary.english.model;

import java.util.List;

public class QuestionModel {
	int numb;
	String question;
	String answer;
	List<String> options;
	public int getNumb() {
		return numb;
	}
	public void setNumb(int numb) {
		this.numb = numb;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "QuestionModel [numb=" + numb + ", question=" + question + ", answer=" + answer + ", options=" + options
				+ "]";
	}
	
}
