package com.myproject.springsecurity.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private Integer id;
	private String firstName;
	private String lastName;
	private String sex;
	private String role;
	private String company;
	private Integer salary;
	
	
	

	public Employee(Integer id, String firstName, String lastName, String sex, String role, String company,
			Integer salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.role = role;
		this.company = company;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public static List<Employee> getEmployees() {

		Employee bijoy = new Employee(1, "Bijoy", "Biswas", "MALE", "Java developer", "TCS", 22);
		Employee suman = new Employee(2, "Suman", "Dey", "MALE", "Java developer", "Mindtree", 17);
		Employee sucharitam = new Employee(3, "Sucharitam", "Choudhary", "MALE", "Java developer", "TCS", 12);
		Employee khan = new Employee(4, "Avijit", "Khan", "MALE", "database developer", "CTS", 20);
		Employee kaustav = new Employee(5, "kaustav", "Ghosha", "MALE", "Net develoer", "CTS", 9);
		Employee srinathDa = new Employee(6, "Srinath", "Mandal", "MALE", "Java developer", "CTS", 19);
		Employee mithun = new Employee(7, "Mithun", "Roy", "MALE", "cloud", "Microsoft", 30);
		Employee sabir = new Employee(8, "Sabir", "muslim", "MALE", "testing", "TCS", 14);
		Employee praghya = new Employee(9, "Praghya", "Chodhurbady", "FEMALE", "testing", "ITC", 20);
		Employee sharmila = new Employee(10, "Sharmila", "Roy", "FEMALE", "testing", "Mindtree", 17);

		List<Employee> emplList = new ArrayList<>();
		emplList.add(bijoy);
		emplList.add(suman);
		emplList.add(sucharitam);
		emplList.add(khan);
		emplList.add(kaustav);
		emplList.add(srinathDa);
		emplList.add(mithun);
		emplList.add(sabir);
		emplList.add(praghya);
		emplList.add(sharmila);

		return emplList;
	}

}
