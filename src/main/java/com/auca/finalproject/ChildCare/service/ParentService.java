package com.auca.finalproject.ChildCare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auca.finalproject.ChildCare.dao.ParentDao;
import com.auca.finalproject.ChildCare.entities.Parent;
import com.auca.finalproject.ChildCare.entities.Sector;

@Service
public class ParentService {

	@Autowired
	private ParentDao parentDao;
	
	@Autowired
	private SectorService sectorSerivce;
	
	public Parent saveParent(Parent parent, int sectorId) {
		
		System.out.println(sectorId);
		Sector sector = sectorSerivce.findSectorById(sectorId);
		System.out.println(sector);
		parent.setSector(sector);
		return parentDao.save(parent);
	}
	
	public Parent findParentById(Integer id) {
		Optional<Parent> parent = parentDao.findById(id);
		
		if(!parent.isPresent()) {
			throw new RuntimeException("Parent not found");
		}
		
		return parent.get();
	}
	
	public List<Parent> findAllParent(){
		return parentDao.findAll();
	}

	
}
