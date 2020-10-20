package com.auca.finalproject.ChildCare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auca.finalproject.ChildCare.dao.ChildDao;
import com.auca.finalproject.ChildCare.entities.Child;
import com.auca.finalproject.ChildCare.entities.Parent;

@Service
public class ChildService {

	@Autowired
	private ChildDao childDao;
	
	@Autowired
	private ParentService parentService;
	
	public Child saveChild(Child child, Integer parentId) {
		Parent parent = parentService.findParentById(parentId);
		child.setParent(parent);
		return childDao.save(child);
	}
	
	public Child findChildById(Integer id) {
		Optional<Child> child = childDao.findById(id);
		
		if(!child.isPresent()) {
			throw new RuntimeException("Child not found");
		}
		
		return child.get();
	}
	
	public List<Child> findAllChildren(){
		return childDao.findAll();
	}
}
