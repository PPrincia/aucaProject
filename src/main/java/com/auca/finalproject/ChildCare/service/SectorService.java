package com.auca.finalproject.ChildCare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.auca.finalproject.ChildCare.dao.SectorDao;
import com.auca.finalproject.ChildCare.entities.District;
import com.auca.finalproject.ChildCare.entities.Parent;
import com.auca.finalproject.ChildCare.entities.Sector;

@Service
public class SectorService {

	@Autowired
	SectorDao sectorDao;
	
	@Autowired
	DistrictService districtService;
	
	@Autowired
	ParentService parentService;
	
	public Sector saveSector(Sector sector, Integer districtId) {
		District district = districtService.findDistrictById(districtId);
		sector.setDistrict(district);
		return sectorDao.save(sector);
	}
	
	public Sector findSectorById(Integer id) {
		
		Optional<Sector> sector = sectorDao.findById(id);
		
		if(sector.isPresent()) {
			
			throw new RuntimeException("Parent not found");
		}
			
			return sector.get();
		
	}
	
	public List<Sector> findAllSector(){
		return sectorDao.findAll();
	}
	
	public void deleteSector(Integer id) {
		
		Sector sector = findSectorById(id);
		
		sectorDao.delete(sector);
		
	}
	
	
	
}
