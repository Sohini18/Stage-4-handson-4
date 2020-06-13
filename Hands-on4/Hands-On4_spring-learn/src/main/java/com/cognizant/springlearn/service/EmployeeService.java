package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public void updateEmployee(Employee employee) {
		try {
			employeeDao.updateEmployee(employee);
		} catch (EmployeeNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id) {
		try {
			employeeDao.deleteEmployee(id);
		} catch (EmployeeNotFoundException e) {

			e.printStackTrace();
		}

	}

}
