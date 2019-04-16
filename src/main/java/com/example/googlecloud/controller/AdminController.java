package com.example.googlecloud.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.googlecloud.model.DangNhap;
import com.example.googlecloud.model.TinTuc;
import com.example.googlecloud.service.DangNhapService;
import com.example.googlecloud.service.LoaiTinService;
import com.example.googlecloud.service.TinTucService;


@Controller
public class AdminController {	
	
	@Autowired
	private TinTucService tinTucService;
	@Autowired
	private LoaiTinService loaiTinService;

	@Autowired
	private DangNhapService dangNhapService;

	// dang nhap
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new DangNhap());
		return "admin";
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		// session.removeAttribute("dn");
		//request.getSession().removeAttribute("user");
		return "redirect:/login";
	}

	@PostMapping("/login/admin")
	public String loginadmin(@Valid DangNhap user, BindingResult result, HttpServletRequest request,
			RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return "login";
		}

		List<DangNhap> dangnhap = (List<DangNhap>) dangNhapService.findAll();

		for (DangNhap list : dangnhap) {
			if (user.getUsername().trim().equals(list.getUsername().trim())) {
				if (user.getPassword().trim().equals(list.getPassword().trim())) {
					//set session
					//request.getSession().setAttribute("user", user);
					return "redirect:/admin";
				}

				else {

					redirect.addFlashAttribute("Error", "Username or Password is not correct");
					return "redirect:/login";
				}
			}

		}
		redirect.addFlashAttribute("Error", "Username or Password is not correct");
		return "redirect:/login";

	}

	// them xoa sua
	@GetMapping("/admin")
	public String index(Model model) {
		model.addAttribute("tintuclist", tinTucService.findAll());
		return "list";
	}

	@GetMapping("/admin/create")
	public String create(Model model) {
		
		//MultipartFile mutipartFile = null ;
		
		//model.addAttribute("mutipartFile", mutipartFile);
		model.addAttribute("tintuc", new TinTuc());
		model.addAttribute("loaitinlist", loaiTinService.findAll());
		return "form";
	}

	@GetMapping("/admin/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("tintuc", tinTucService.findOne(id));
		model.addAttribute("loaitinlist", loaiTinService.findAll());
		return "form";
	}

	@PostMapping("/admin/save")
	public String save(@Valid TinTuc tintuc, BindingResult result, RedirectAttributes redirectAttributes) throws Exception {
		/*
		File uploadRootDir = new File("src/main/resources/static/img");
		if(!uploadRootDir.exists()){
			
			uploadRootDir.mkdirs();
		}
		
		MultipartFile fileData = tintuc.getFile();
		
		String fileName = fileData.getOriginalFilename();
		System.out.println("fileName");
		
		File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + fileName);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(fileData.getBytes());
		stream.close();
		
		String imgLink = "/img/" + fileName;
		
		if (result.hasErrors()) {
			return "form";
		}
		tintuc.setHinhAnh(imgLink);*/
		tinTucService.save(tintuc);
		redirectAttributes.addFlashAttribute("success", "Saved news successfully!");
		return "redirect:/admin";
	}

	@GetMapping("/admin/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		tinTucService.delete(id);
		redirect.addFlashAttribute("success", "Deleted news successfully!");
		return "redirect:/admin";
	}
	
}