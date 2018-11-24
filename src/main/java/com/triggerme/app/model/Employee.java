package com.triggerme.app.model;

import java.time.LocalDate;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document(collection = "employees")
@Scope("session")
@JsonInclude(Include.NON_EMPTY)
public class Employee {

	@Id
	private String empId;
	
	private String empFName;
	
	private String empLName;
	
	@Indexed(unique = true)
	private String phoneNumber;
	
	@Indexed(unique = true)
	private String email;
	
	private String status;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate statusStartDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate statusEndDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate projectStartDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate projectEndDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate empStartDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate empEndDate;
	
	private boolean isEmpEVerifyStatus;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpFName() {
		return empFName;
	}

	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}

	public String getEmpLName() {
		return empLName;
	}

	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getStatusStartDate() {
		return statusStartDate;
	}

	public void setStatusStartDate(LocalDate statusStartDate) {
		this.statusStartDate = statusStartDate;
	}

	public LocalDate getStatusEndDate() {
		return statusEndDate;
	}

	public void setStatusEndDate(LocalDate statusEndDate) {
		this.statusEndDate = statusEndDate;
	}

	public LocalDate getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(LocalDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public LocalDate getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(LocalDate projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public LocalDate getEmpStartDate() {
		return empStartDate;
	}

	public void setEmpStartDate(LocalDate empStartDate) {
		this.empStartDate = empStartDate;
	}

	public LocalDate getEmpEndDate() {
		return empEndDate;
	}

	public void setEmpEndDate(LocalDate empEndDate) {
		this.empEndDate = empEndDate;
	}

	public boolean isEmpEVerifyStatus() {
		return isEmpEVerifyStatus;
	}

	public void setIsEmpEVerifyStatus(boolean isEmpEVerifyStatus) {
		this.isEmpEVerifyStatus = isEmpEVerifyStatus;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFName=" + empFName + ", empLName=" + empLName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", status=" + status + ", statusStartDate=" + statusStartDate
				+ ", statusEndDate=" + statusEndDate + ", projectStartDate=" + projectStartDate + ", projectEndDate="
				+ projectEndDate + ", empStartDate=" + empStartDate + ", empEndDate=" + empEndDate
				+ ", isEmpEVerifyStatus=" + isEmpEVerifyStatus + "]";
	}


	
}
