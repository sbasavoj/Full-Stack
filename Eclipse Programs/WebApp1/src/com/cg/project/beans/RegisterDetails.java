package com.cg.project.beans;

import java.util.ArrayList;
import java.util.List;

public class RegisterDetails {
	private String name,emailId,gender,graduation,userName,password,rPassword;
	private int age;
	private double mobileNo;
	private ArrayList<String> communicationMode;
	public RegisterDetails(String name, String emailId, String gender, String graduation, String userName,
			String password, String rPassword, int age, double mobileNo, ArrayList<String> communicationMode) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.gender = gender;
		this.graduation = graduation;
		this.userName = userName;
		this.password = password;
		this.rPassword = rPassword;
		this.age = age;
		this.mobileNo = mobileNo;
		this.communicationMode = communicationMode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getrPassword() {
		return rPassword;
	}
	public void setrPassword(String rPassword) {
		this.rPassword = rPassword;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(double mobileNo) {
		this.mobileNo = mobileNo;
	}
	public ArrayList<String> getCommunicationMode() {
		return communicationMode;
	}
	public void setCommunicationMode(ArrayList<String> communicationMode) {
		this.communicationMode = communicationMode;
	}
	@Override
	public String toString() {
		return "RegisterDetails [name=" + name + ", emailId=" + emailId + ", gender=" + gender + ", graduation="
				+ graduation + ", userName=" + userName + ", password=" + password + ", rPassword=" + rPassword
				+ ", age=" + age + ", mobileNo=" + mobileNo + ", communicationMode=" + communicationMode + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((communicationMode == null) ? 0 : communicationMode.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((graduation == null) ? 0 : graduation.hashCode());
		long temp;
		temp = Double.doubleToLongBits(mobileNo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rPassword == null) ? 0 : rPassword.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterDetails other = (RegisterDetails) obj;
		if (age != other.age)
			return false;
		if (communicationMode == null) {
			if (other.communicationMode != null)
				return false;
		} else if (!communicationMode.equals(other.communicationMode))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (graduation == null) {
			if (other.graduation != null)
				return false;
		} else if (!graduation.equals(other.graduation))
			return false;
		if (Double.doubleToLongBits(mobileNo) != Double.doubleToLongBits(other.mobileNo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rPassword == null) {
			if (other.rPassword != null)
				return false;
		} else if (!rPassword.equals(other.rPassword))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	} 
}
