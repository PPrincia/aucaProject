package com.auca.finalproject.ChildCare.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Disease {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private String diseaseId;
	private String name;
	private String category;
	private String severity;
	private Date deadline;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
				cascade = {CascadeType.DETACH, CascadeType.MERGE,
							CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "disease_child",
				joinColumns = @JoinColumn(name = "disease_id"),
				inverseJoinColumns = @JoinColumn(name = "child_id"))
	private List<Child> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}
	
	public void assignDisease(Child child) {
		if (children == null) {
			children = new ArrayList<>();
		}

		children.add(child);
	}
	
}
