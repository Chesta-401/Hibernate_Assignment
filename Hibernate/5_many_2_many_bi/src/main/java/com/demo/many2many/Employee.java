package com.demo.many2many;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
//There is no rule to select owner and rev owner in case of M to M
//..........................................................1 to 1

//there is a rule in case of of 1 to M
//owner M side rev owner 1 side

@Entity
@Table(name = "emp_table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	@JoinTable(name = "emp_project_jt_table",
			joinColumns = @JoinColumn(name = "eid_fk"), 
			inverseJoinColumns = @JoinColumn(name = "pid_fk"))
	@ManyToMany
	private List<Project> projects = new ArrayList<Project>();

	public Employee() {
	}

	public Employee(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

}
