package com.example.googlecloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.googlecloud.model.TinTuc;
import com.example.googlecloud.dao.TinTucRepository;

@Service
public class TinTucServiceImpl implements TinTucService {

	@Autowired
	private TinTucRepository tinTucRepository;

	@Override
	public Iterable<TinTuc> findAll() {
		return tinTucRepository.findAll();
	}
	/*
	@Override
	public List<TinTuc> search(String q) {
		return tinTucRepository.findByNameContaining(q);
	}*/

	@Override
	public TinTuc findOne(int id) {
		return tinTucRepository.findOne(id);
	}
	
	

	@Override
	public void save(TinTuc contact) {
		tinTucRepository.save(contact);
	}

	@Override
	public void delete(int id) {
		tinTucRepository.delete(id);
	}

}
