package com.example.googlecloud.service;

import java.util.List;
import java.util.Optional;

import com.example.googlecloud.model.LoaiTin;

public interface LoaiTinService {

	Iterable<LoaiTin> findAll();
	
	void save(LoaiTin contact);

	void delete(int id);

	LoaiTin findOne(int id);

	
}
