package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@GetMapping()
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();

	}

	@PutMapping()
	public void updateEmployee(@RequestBody @Valid Employee employee) {
		LOGGER.info("Start");
		employeeService.updateEmployee(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable int id) {
		LOGGER.info("Start");
		employeeService.deleteEmployee(id);
		LOGGER.debug("Employee List After Deletions:{}", employeeService.getAllEmployees());
		LOGGER.info("End");
	}

}
