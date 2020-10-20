package com.auca.finalproject.ChildCare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.finalproject.ChildCare.entities.Child;

public interface ChildDao extends JpaRepository<Child, Integer>{

}
