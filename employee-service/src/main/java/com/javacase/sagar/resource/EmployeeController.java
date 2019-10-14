package com.javacase.sagar.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javacase.sagar.model.Employee;

@RestController
public class EmployeeController {

	private static final Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>() {

		private static final long serialVersionUID = -3970206781360313502L;
		{
			put(111, new Employee(111, "Employee1"));
			put(222, new Employee(222, "Employee2"));
		}
	};

	@GetMapping(value = "/findEmployeeDetails/{employeeId}")
	public Employee getEmployeeDetails(@PathVariable("employeeId") int id) {
		return employeeData.get(id);
	}

}
