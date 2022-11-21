package com.hcmue.vocabulary.english.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcmue.vocabulary.english.model.VocabularyTypeModel;

@Entity
@Table(name = "vocabulary_type")
public class VocabularyType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vocabulary_type;
	@Column(name = "id_vocabulary")
	private int id_vocabulary;
	@Column(name = "id_type_of_words")
	private int id_type_of_words;
	@Column(name = "type_detail")
	private String type;
	@Column(name = "status_vocabulary_type")
	private Boolean status_vocabulary_type;
	public int getId_vocabulary_type() {
		return id_vocabulary_type;
	}
	public int getId_vocabulary() {
		return id_vocabulary;
	}
	public String getType() {
		return type;
	}
	public Boolean getStatus_vocabulary_type() {
		return status_vocabulary_type;
	}
	public int getId_type_of_words() {
		return id_type_of_words;
	}
	public VocabularyType(VocabularyTypeModel m) {
		this.id_vocabulary_type = m.getId_vocabulary_type();
		this.id_vocabulary = m.getId_vocabulary();
		this.id_type_of_words = m.getId_type_of_words();
		this.type = m.getType();
		this.status_vocabulary_type = m.getStatus_vocabulary_type();
	}
	public VocabularyType() {
		this.status_vocabulary_type = true;
	}
}
