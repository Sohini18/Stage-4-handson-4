package com.cognizant.springlearn;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonFormat;




public class Employee {
	@NotNull
	@Min(0)
	@Max(9)
	private int id;
	@NotNull
	@Size(min=1,max=30,message="Size between 1 and 30")
	private String name;
	@NotNull
	@Min(0)
	private double salary;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
	private Date dateOfBirth;
	
	private Department department;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);
	
	public Employee() {
		super();
		
		LOGGER.info("Employe Object created Successfully");
	}
	
	

	public Employee(@NotNull @Min(0) @Max(9) int id,
			@NotNull @Size(min = 1, max = 30, message = "Size between 1 and 30") String name,
			@NotNull @Min(0) double salary, Date dateOfBirth, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dateOfBirth=" + dateOfBirth
				+ ", department=" + department + "]";
	}
	
	
}
