package dao;

import org.springframework.stereotype.Component;

import model.EmployeeUser;

@Component
public class UserStatusModal {
	
	private int status;
	private String message;
	private EmployeeUser user;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EmployeeUser getUser() {
		return user;
	}
	public void setUser(EmployeeUser user) {
		this.user = user;
	}
	
}