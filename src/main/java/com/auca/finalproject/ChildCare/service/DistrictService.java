package com.auca.finalproject.ChildCare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auca.finalproject.ChildCare.dao.DistrictDao;
import com.auca.finalproject.ChildCare.entities.District;
import com.auca.finalproject.ChildCare.entities.Province;

@Service
public class DistrictService {

	@Autowired
	private DistrictDao districtDao;
	
	@Autowired
	ProvinceService provinceService;
	
	public District saveDistrict(District district, Integer provinceId) {
		Province province = provinceService.findProvinceById(provinceId);
		district.setProvince(province);
		return districtDao.save(district);
	}
	
	public District findDistrictById(Integer id) {
		Optional<District> district = districtDao.findById(id);
		
		if(!district.isPresent()) {
			throw new RuntimeException("District not found");
		}
		
		return district.get();
	}
	
	public List<District> findAllDistrict(){
		return districtDao.findAll();
	}
	
	public List<District> findAllDistrictByProvinceId(Integer provinceId){
		Province province = provinceService.findProvinceById(provinceId);
		return province.getDistricts();
	}
}
