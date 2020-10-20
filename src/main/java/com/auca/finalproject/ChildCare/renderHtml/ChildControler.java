package com.auca.finalproject.ChildCare.renderHtml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auca.finalproject.ChildCare.entities.Child;
import com.auca.finalproject.ChildCare.service.ChildService;

@Controller
@RequestMapping("/child")
public class ChildControler {

	@Autowired
	private ChildService childService;
	
	@GetMapping
	public String displayChildren(Model model) {
		List<Child> children = childService.findAllChildren();
		model.addAttribute("allChildren", children);
		
		return "person/child-list";
	}
	
	@GetMapping("/new")
	public String displayChildForm(Model model) {
		Child aChild = new Child();
		model.addAttribute("child", aChild);
		
		return "person/new-child";
	}
	
	@PostMapping("/save")
	public String createChild(Child child, Model model, int parentId) {
		childService.saveChild(child, parentId);
		
		return "redirect:/person/child-list";
	}
}
