package com.hcmue.vocabulary.english.services;

import java.util.List;

public interface Services<T>{
	List<T> listAll();
	T findOne(int id);
	void update(T t);
	void delete(int id);
}

