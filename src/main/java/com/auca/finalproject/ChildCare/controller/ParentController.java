package com.auca.finalproject.ChildCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auca.finalproject.ChildCare.entities.Parent;
import com.auca.finalproject.ChildCare.service.ParentService;

@RestController
@RequestMapping("api/person")
@CrossOrigin
public class ParentController {

	@Autowired
	private ParentService parentService;
	
	
	@PostMapping("/parent/{sectorId}")
	public ResponseEntity<?> saveParent(@RequestBody Parent parent, @PathVariable int sectorId){
		
		Parent newParent = parentService.saveParent(parent, sectorId);
		return new ResponseEntity<Parent> (newParent, HttpStatus.CREATED);
	}
	
	@GetMapping("/parent/{parentId}")
	public ResponseEntity<?> findParent(@PathVariable int parentId){
		
		Parent parent = parentService.findParentById(parentId);
		return new ResponseEntity<Parent> (parent, HttpStatus.OK);
	}
	
	@GetMapping("/parent")
	public List<Parent> findAllParent(){
		List<Parent> allParent = parentService.findAllParent();
		return allParent;
	}
}
