package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Librarian {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int librarianId;
	private String librarianName;
	private String librarianEmail;
	private String librarianMobileNumber;
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Librarian(int librarianId, String librarianName, String librarianEmail, String librarianMobileNumber) {
		super();
		this.librarianId = librarianId;
		this.librarianName = librarianName;
		this.librarianEmail = librarianEmail;
		this.librarianMobileNumber = librarianMobileNumber;
	}
	public int getLibrarianId() {
		return librarianId;
	}
	public void setLibrarianId(int librarianId) {
		this.librarianId = librarianId;
	}
	public String getLibrarianName() {
		return librarianName;
	}
	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}
	public String getLibrarianEmail() {
		return librarianEmail;
	}
	public void setLibrarianEmail(String librarianEmail) {
		this.librarianEmail = librarianEmail;
	}
	public String getLibrarianMobileNumber() {
		return librarianMobileNumber;
	}
	public void setLibrarianMobileNumber(String librarianMobileNumber) {
		this.librarianMobileNumber = librarianMobileNumber;
	}
	
}
