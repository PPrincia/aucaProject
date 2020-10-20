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

import com.auca.finalproject.ChildCare.entities.Child;
import com.auca.finalproject.ChildCare.service.ChildService;

@RestController
@RequestMapping("api/person")
@CrossOrigin
public class ChildController {

	@Autowired
	private ChildService childService;
	
	@PostMapping("/child/{parentId}")
	public ResponseEntity<?> saveChild(@RequestBody Child child, @PathVariable int parentId){
		
		Child newChild = childService.saveChild(child, parentId);
		return new ResponseEntity<Child> (newChild, HttpStatus.CREATED);
	}
	
	@GetMapping("/child/{childId}")
	public ResponseEntity<?> findChild(@PathVariable Integer childId){
		
		Child child = childService.findChildById(childId);
		return new ResponseEntity<Child> (child, HttpStatus.OK);
	}
	
	@GetMapping("/child")
	public List<Child> findAllChildren(){
		List<Child> allChildren = childService.findAllChildren();
		return allChildren;
	}
}
