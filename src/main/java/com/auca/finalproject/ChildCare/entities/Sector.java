package com.auca.finalproject.ChildCare.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sector {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "district_id")
	private District district;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
	private List<Parent> parents;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}
	
	public void assignSector(Parent parent) {
		if(parents ==null) {
			parents = new ArrayList<>();
		}
		
		parents.add(parent);
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", name=" + name + "]";
	}

	
	
}
