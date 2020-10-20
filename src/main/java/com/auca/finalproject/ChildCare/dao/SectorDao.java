package com.auca.finalproject.ChildCare.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.finalproject.ChildCare.entities.Sector;

public interface SectorDao extends JpaRepository<Sector, Integer>{

	
}
