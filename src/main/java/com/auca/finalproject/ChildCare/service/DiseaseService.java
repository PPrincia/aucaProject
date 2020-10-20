package com.auca.finalproject.ChildCare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.auca.finalproject.ChildCare.dao.DiseaseDao;
import com.auca.finalproject.ChildCare.entities.Child;
import com.auca.finalproject.ChildCare.entities.Disease;

@Service
public class DiseaseService {

	@Autowired
	private DiseaseDao diseaseDao;

	@Autowired
	private ChildService childService;
	
	public Disease saveDisease(Disease disease) {
		
		
			return diseaseDao.save(disease);
		
	}
	
	public Disease findDiseaseById(Integer id) {
		Optional<Disease> disease = diseaseDao.findById(id);
		if(!disease.isPresent()) {
			throw new RuntimeException("Disease not found");
		}
		 return disease.get();
	}
	
	public List<Disease> findAllDiseases(){
		return diseaseDao.findAll();
	}
	
	public String addPatient(int diseaseId, int childId) {
		Disease disease = findDiseaseById(diseaseId);
		Child child = childService.findChildById(childId);
		disease.assignDisease(child);
		diseaseDao.save(disease);
		return "You've assigned a disease to a patient";
	}
}
