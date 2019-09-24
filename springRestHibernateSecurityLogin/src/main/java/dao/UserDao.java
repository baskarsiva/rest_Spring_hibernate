package dao;

import java.sql.SQLException;

import model.EmployeeUser;

public interface UserDao {

	
	public EmployeeUser getUser(String userId);
	public String saveUser(EmployeeUser user) throws SQLException;
}
