package com.example.googlecloud.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.googlecloud.model.TinTuc;

public interface TinTucRepository extends CrudRepository<TinTuc, Integer> {
	//List<TinTuc> findByNameContaining(String q);

	
}
