package com.auca.finalproject.ChildCare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.finalproject.ChildCare.entities.Disease;

public interface DiseaseDao extends JpaRepository<Disease, Integer>{

}
