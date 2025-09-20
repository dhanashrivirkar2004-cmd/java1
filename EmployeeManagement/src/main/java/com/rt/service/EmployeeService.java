package com.rt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.entity.Employee;
import com.rt.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository EmployeeRepository;

	public void addEmployee(Employee e) {
		EmployeeRepository.save(e);

	}

	public void removeEmployee(int id) {

		EmployeeRepository.deleteById(id);
	}

	public Employee getEmployeeData(int roll_N0) {

		Optional<Employee> opt = EmployeeRepository.findById(roll_N0);

		if (opt.isEmpty()) {
			return null;

		}
		return opt.get();
	}

	public List GetAllEmployeeData() {
		return EmployeeRepository.findAll();

	}

	public Object updateRecord(Employee employee, int id) {

		Optional<Employee> opt = EmployeeRepository.findById(id);

		if (opt.isEmpty()) {
			return null;

		}
		Employee epmloyee1 = opt.get();

		epmloyee1.setId(employee.getId());
		epmloyee1.setName(employee.getName());
		epmloyee1.setSalary(employee.getSalary());

		EmployeeRepository.save(epmloyee1);

		return "Employee Updated Successfully";
	}

	public Employee getEmployeeDatabyname(String name, int id) {
		Optional<Employee> opt = EmployeeRepository.findByNameById(name, id);

		if (opt.isEmpty()) {
			return null;

		}
		return opt.get();
	}

	public void removeEmployeebyname(String name) {
		EmployeeRepository.deleteByName(name);
	}

	public Integer getTotalMarks() {
		Integer sum = EmployeeRepository.sumOfMark();
		return sum != null ? sum : 0;
	}

}
