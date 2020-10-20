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

import com.auca.finalproject.ChildCare.entities.Disease;
import com.auca.finalproject.ChildCare.service.DiseaseService;

@RestController
@RequestMapping("api/illness")
@CrossOrigin
public class DiseaseController {

	@Autowired
	private DiseaseService diseaseService;
	
	@PostMapping("/disease")
	public ResponseEntity<?> saveDisease(@RequestBody Disease disease){
		Disease newDisease = diseaseService.saveDisease(disease);
		return new ResponseEntity<Disease> (newDisease, HttpStatus.CREATED);
	}
	
	@PostMapping("/assign/{diseaseId}/{childId}")
	public ResponseEntity<?> assignDisease(@PathVariable int diseaseId, @PathVariable int childId){
		String msg = diseaseService.addPatient(diseaseId, childId);
		return new ResponseEntity<String> (msg, HttpStatus.OK);
	}
	
	@GetMapping("/disease")
	public List<Disease> getAllDisease(){
		List<Disease> disease = diseaseService.findAllDiseases();
		return disease;
	}
	
	@GetMapping("/disease/{diseaseId}")
	public ResponseEntity<?> getDiseaseById(@PathVariable int diseaseId){
		Disease disease = diseaseService.findDiseaseById(diseaseId);
		
		return new ResponseEntity<Disease> (disease, HttpStatus.OK);
	}
	
}
