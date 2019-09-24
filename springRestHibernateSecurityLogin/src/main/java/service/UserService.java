package service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDaoImpl;
import model.EmployeeUser;

@Service
public class UserService {

//	@Autowired
	EmployeeUser user;

	@Autowired
	UserDaoImpl daoImpl ;

	public EmployeeUser getUser() {
		return user;
	}

	public void setUser(EmployeeUser user) {
		this.user = user;
	}

	public UserDaoImpl getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(UserDaoImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

	public EmployeeUser getUser(String userId) {
		user = daoImpl.getUser(userId);
		return user;
	}

	public String saveUser(EmployeeUser user1) throws SQLException {
		user = user1;
		daoImpl.saveUser(user);
		return "Success";
	}

}
