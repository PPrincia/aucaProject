package com.auca.finalproject.ChildCare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auca.finalproject.ChildCare.dao.ProvinceDao;
import com.auca.finalproject.ChildCare.entities.Province;

@Service
public class ProvinceService {

	@Autowired
	private ProvinceDao provinceDao;
	
	public Province saveProvince(Province province) {
		return provinceDao.save(province);
	}
	
	public Province findProvinceById(Integer id) {
		Optional<Province> provinces = provinceDao.findById(id);
		
		if(!provinces.isPresent()) {
			throw new RuntimeException("Province not found");
		}
		
		return provinces.get();
	}
	
	public List<Province> findAllProvince(){
		return provinceDao.findAll();
	}
	
	public Province updateProvince(Province province) {
		if(province.getId() != null) {
			if(provinceDao.existsById(province.getId())) {
				return provinceDao.save(province);
			}
			else {
				throw new RuntimeException("Province id " + province.getId() + "does not exist");
			}
		}
		else {
			throw new RuntimeException("cannot update province because it does not exist");
		}
	}
	
	public void deleteProvince(Integer id) {
		Province province =findProvinceById(id);
		provinceDao.delete(province);
	}
}
