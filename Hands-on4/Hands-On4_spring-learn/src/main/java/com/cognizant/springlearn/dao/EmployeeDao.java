package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao {

	private static List<Employee> EMPLOYEE_LIST;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");

		EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList");
		LOGGER.debug("Employes:{}", EMPLOYEE_LIST);

	}

	public List<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	public Employee getEmployeeById(int id) {
		Employee employee = null;
		for (Employee employeeIterator : EMPLOYEE_LIST) {

			if (employeeIterator.getId() == id) {
				employee = employeeIterator;

			}

		}
		return employee;
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException  {
		LOGGER.info("Start");
		Employee employeeRequired=null;
		employeeRequired=getEmployeeById(employee.getId());
		if (employeeRequired==null) {
				throw new EmployeeNotFoundException("EmployeeNotFound");
			}
		employeeRequired.setId(employee.getId());
		employeeRequired.setName(employee.getName());
	
		LOGGER.debug("Employee Updated:{}", employee);
		LOGGER.info("End");
	}
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		LOGGER.info("Start");
		Employee employee=null;
		employee=getEmployeeById(id);
		if(employee==null) {
			throw new EmployeeNotFoundException("EmployeeNotFound");
					
		}
		EMPLOYEE_LIST.remove(employee);
		LOGGER.info("End");
	}

}
