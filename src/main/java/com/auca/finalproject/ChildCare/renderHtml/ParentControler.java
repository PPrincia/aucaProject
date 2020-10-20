package com.auca.finalproject.ChildCare.renderHtml;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.auca.finalproject.ChildCare.entities.Parent;
import com.auca.finalproject.ChildCare.entities.Sector;
import com.auca.finalproject.ChildCare.service.ParentService;
import com.auca.finalproject.ChildCare.service.SectorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/parents")
public class ParentControler {

	@Autowired
	ParentService parentService;
	
	@Autowired
	SectorService sectorService;

	
	@GetMapping
	public String displayParent(Model model) {
		List<Parent> parents = parentService.findAllParent();
		model.addAttribute("allParents", parents);
		
		return "person/parent-list";
	}
	
	@GetMapping("/new")
	public String displayParentForm(Model model) throws JsonProcessingException {
		Parent aParent = new Parent();
		List<Sector> sectors = sectorService.findAllSector();
		model.addAttribute("parent", aParent);
		
		model.addAttribute("allSectors", sectors);
		return "person/new-parent";
	}
	
	
	
	@PostMapping("/save")
	public String createParent(Parent parent, Model model, int id) {
		
		parentService.saveParent(parent, id);
		return "redirect:/parents";
		
	}
}
