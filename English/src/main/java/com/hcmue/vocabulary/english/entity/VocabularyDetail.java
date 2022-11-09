package com.hcmue.vocabulary.english.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.vocabulary.english.model.VocabularyDetailModel;

@Entity
@Table(name = "vocabulary_detail")
public class VocabularyDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vocabulary_detail;
	@Column(name = "id_vocabulary_type")
	private int id_vocabulary_type;
	@Column(name = "mean")
	private String mean;
	@Column(name = "example_detail")
	private String example;
	@Column(name = "status_vocabulary_detail")
	private Boolean status_vocabulary_detail;
	public int getId_vocabulary_detail() {
		return id_vocabulary_detail;
	}
	public int getId_vocabulary_type() {
		return id_vocabulary_type;
	}
	public String getMean() {
		return mean;
	}
	public Boolean getStatus_vocabulary_detail() {
		return status_vocabulary_detail;
	}
	public String getExample() {
		return example;
	}
	public VocabularyDetail(VocabularyDetailModel v) {
		this.id_vocabulary_detail = v.getId_vocabulary_detail();
		this.id_vocabulary_type = v.getId_vocabulary_type();
		this.mean = v.getMean();
		this.example = v.getExample();
		this.status_vocabulary_detail = v.getStatus_vocabulary_detail();
	}
	public VocabularyDetail() {
		this.status_vocabulary_detail = true;
	}
	
}
