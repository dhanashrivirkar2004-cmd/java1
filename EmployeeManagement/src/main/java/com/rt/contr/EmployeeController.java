package com.rt.contr;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rt.entity.Employee;
import com.rt.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService Employeeservice;

	@PostMapping("/Employee")
	public String addEmployee(@Valid @RequestBody Employee employee) {
		Employeeservice.addEmployee(employee);
		return "Employee Added Successfully";

	}

	@GetMapping("/total-marks")
	public ResponseEntity<Integer> getTotalMarks() {
		Integer total = Employeeservice.getTotalMarks();
		return ResponseEntity.ok(total);
	}

	@DeleteMapping("/Employee/{id}")
	public String removeEmployee(@PathVariable int id) {
		Employeeservice.removeEmployee(id);
		return "Employee Deleted Successfully";

	}

	@GetMapping("/Employee/{id}")
	public Employee getEmployee(@PathVariable int id) {

		Employee st = Employeeservice.getEmployeeData(id);
		return st;

	}

	@GetMapping("/Employee")
	public List<Employee> GetAllEmployeeData() {
		List<Employee> Employee = Employeeservice.GetAllEmployeeData();
		return Employee;

	}

	@PutMapping("Employee/{id}")
	public String UpdateEmployeeData(@RequestBody Employee employee, @PathVariable int id) {
		String rs = (String) Employeeservice.updateRecord(employee, id);

		if (rs == null) {
			return "Record not found";
		}

		return "updated";
	}

	@GetMapping("/hii")
	public String m1() {
		return "hello";
	}

	@DeleteMapping("/Employee1/{name}")
	public String removeEmployeebyname(@PathVariable String name) {
		Employeeservice.removeEmployeebyname(name);
		return "Employee Deleted Successfully";

	}

	@GetMapping("/byname/{name}/{id}")
	public Employee getEmployybyname(@PathVariable String name, @PathVariable int id) {
		Employee st = Employeeservice.getEmployeeDatabyname(name, id);
		return st;

	}

}
