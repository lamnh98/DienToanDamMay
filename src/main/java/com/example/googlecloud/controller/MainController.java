package com.example.googlecloud.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import com.bphvcg.awsproject.Quickstart;
import com.example.googlecloud.model.TinTuc;
import com.example.googlecloud.model.LoaiTin;
import com.example.googlecloud.service.TinTucService;
import com.example.googlecloud.service.LoaiTinService;

@Controller
public class MainController {
	
	@Autowired
	private TinTucService tinTucService;
	
	@Autowired
	public LoaiTinService loaiTinService;
	

	@GetMapping("/")
	public String home() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("tintuclist", tinTucService.findAll());
		model.addAttribute("loaitinlist", loaiTinService.findAll());
		/*
		LoaiTin loaitin = loaiTinService.findOne(1);		
		Collection<TinTuc>  tin = loaitin.getTintuc();
		List<TinTuc> tintuclist = (List<TinTuc>) tin;
		model.addAttribute("tintuclist", tintuclist);*/
		return "home";
	}
	@GetMapping("/home/{id}")
	public String index(@PathVariable int id,Model model) {
		
		//model.addAttribute("tintuclist", tinTucService.findAll());
		model.addAttribute("loaitinlist", loaiTinService.findAll());
		
		LoaiTin loaitin = loaiTinService.findOne(id);		
		Collection<TinTuc>  tin = loaitin.getTintuc();
		List<TinTuc> tintuclist = (List<TinTuc>) tin;
		model.addAttribute("tintuclist", tintuclist);
		return "home";
	}
	
	@GetMapping("/noidung/{id}")
	public String noidung(@PathVariable int id ,Model model) {
		
		model.addAttribute("tintuclist", tinTucService.findOne(id));
		model.addAttribute("loaitinlist", loaiTinService.findAll());
		/*
		LoaiTin loaitin = loaiTinService.findOne(1);		
		Collection<TinTuc>  tin = loaitin.getTintuc();
		List<TinTuc> tintuclist = (List<TinTuc>) tin;
		model.addAttribute("tintuclist", tintuclist);*/
		return "blog-post";
	}
	
}
