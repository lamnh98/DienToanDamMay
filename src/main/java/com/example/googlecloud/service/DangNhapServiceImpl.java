package com.example.googlecloud.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.googlecloud.dao.DangNhapRepository;
import com.example.googlecloud.model.DangNhap;
import com.example.googlecloud.model.TinTuc;



@Service
public class DangNhapServiceImpl implements DangNhapService {
    @Autowired
    private DangNhapRepository dangNhapRepository;
    
    @Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    
    @Override
	public Iterable<DangNhap> findAll() {
		return dangNhapRepository.findAll();
	}
}
