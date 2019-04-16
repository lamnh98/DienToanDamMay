package com.example.googlecloud.service;

import java.util.List;
import java.util.Optional;

import com.example.googlecloud.model.TinTuc;

public interface TinTucService {

	Iterable<TinTuc> findAll();
	
	
	//List<TinTuc> search(String q);

	TinTuc findOne(int id);
	
	

	void save(TinTuc contact);

	void delete(int id);

}
