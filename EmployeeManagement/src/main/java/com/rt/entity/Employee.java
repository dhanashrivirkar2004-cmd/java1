package com.rt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	@NotEmpty(message = "name must be add")
	@Size(min = 3, max = 10, message = "name character should be b/w 3 and 10")
	private String name;
	@Positive(message = "Enter only positive number")
	private int salary;
	private String address;

	public Employee() {

	}

	public Employee(int id, String name, int salary, String address) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
