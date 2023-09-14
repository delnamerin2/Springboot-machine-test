package com.nissan.dto;

public class EmployeeDeptDTO {

	private Integer id;
	private String employeeName;
	private String departmentName;

	public EmployeeDeptDTO(Integer id, String employeeName, String departmentName) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.departmentName = departmentName;
	}

	public EmployeeDeptDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
