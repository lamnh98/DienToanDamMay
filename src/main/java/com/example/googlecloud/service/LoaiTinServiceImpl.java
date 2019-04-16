package com.example.googlecloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.googlecloud.model.LoaiTin;
import com.example.googlecloud.dao.LoaiTinRepository;

@Service
public class LoaiTinServiceImpl implements LoaiTinService {

	@Autowired
	private LoaiTinRepository loaiTinRepository;

	@Override
	public Iterable<LoaiTin> findAll() {
		return loaiTinRepository.findAll();
	}

	@Override
	public LoaiTin findOne(int id) {
		return loaiTinRepository.findOne(id);
	}
	@Override
	public void save(LoaiTin contact) {
		loaiTinRepository.save(contact);
	}

	@Override
	public void delete(int id) {
		loaiTinRepository.delete(id);
	}

}
