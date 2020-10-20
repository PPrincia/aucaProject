package com.auca.finalproject.ChildCare.renderHtml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auca.finalproject.ChildCare.entities.Province;
import com.auca.finalproject.ChildCare.service.ProvinceService;

@Controller
@RequestMapping("/provinces")
public class ProvinceControler {

	@Autowired
	private ProvinceService provinceService;
	
	@GetMapping
	public String displayProvince(Model model) {
		List<Province> provinces = provinceService.findAllProvince();
		model.addAttribute("allProvinces", provinces);
		
		return "location/province-list";
	}
	
	@GetMapping("/new")
	public String displayProvincesForm(Model model) {
		Province aProvince = new Province();
		model.addAttribute("province", aProvince);
		
		return "location/new-province";
	}
	
	@PostMapping("/save")
	public String createProvince(Province province, Model model) {
		provinceService.saveProvince(province);
		
		return "redirect:/provinces";
	}
}
