package com.cognizant.springlearn;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Department {
	@NotNull
	@Min(0)
	@Max(9)
	private int id;
	@NotNull
	@Size(min=1,max=30)
	private String name;
	private String location;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Department.class);
	
	public Department() {
		super();
		LOGGER.info("Deapartment Object created Successfully");
		
	}
	
	

	public Department(@NotNull @Min(0) @Max(9) int id, @NotNull @Size(min = 1, max = 30) String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	
	
}
