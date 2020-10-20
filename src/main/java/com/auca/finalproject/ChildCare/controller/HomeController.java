package com.auca.finalproject.ChildCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auca.finalproject.ChildCare.dao.ChildDao;
import com.auca.finalproject.ChildCare.dao.DiseaseDao;
import com.auca.finalproject.ChildCare.dao.DistrictDao;
import com.auca.finalproject.ChildCare.dao.ParentDao;
import com.auca.finalproject.ChildCare.dao.ProvinceDao;
import com.auca.finalproject.ChildCare.dao.SectorDao;
import com.auca.finalproject.ChildCare.entities.Child;
import com.auca.finalproject.ChildCare.entities.Parent;
import com.auca.finalproject.ChildCare.entities.Province;

@RestController
@RequestMapping("api/home")
@CrossOrigin
public class HomeController {

	@Autowired
	private ProvinceDao provinceDao;
	
	@Autowired
	private DistrictDao districtDao;
	
	@Autowired
	private SectorDao sectorDao;
	
	@Autowired
	private ParentDao parentDao;
	
	@Autowired
	private ChildDao childDao;
	
	@Autowired
	private DiseaseDao diseaseDao;
	
	
	public String displayHome(Model model) {
		List<Province> provinces = provinceDao.findAll();
		List<Parent> parents = parentDao.findAll();
		List<Child> children = childDao.findAll();
		
		model.addAttribute("provinceList", provinces);
		model.addAttribute("parentList", parents);
		model.addAttribute("childList", children);
		
		return "main/home";
	} 
}
