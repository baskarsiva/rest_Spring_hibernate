
package com.baskar.rest;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import dao.UserStatusModal;
import model.EmployeeUser;
import service.UserService;

/**
 * Example resource class hosted at the URI path "/myresource"
 */

//pathparam URL - :  http://localhost:8080/springRestHibernateSecurityLogin/web/login/get/user1/user1

//queryparam URL -   http://localhost:8080/springRestHibernateSecurityLogin/web/login/get?userId=1

//@Path("/user-info/{userId}")
//public UserStatusModal getUser(@PathParam("userId") long userId) {

//	@Path("/user-info/")
//	public UserStatusModal getUser(@QueryParam("userId") long userId){

@Component
@Path("/login")

public class MyResource {

	@Autowired
	UserService userService;
	
	@Autowired
	UserStatusModal userStatusresponse;

//	@Autowired
//	User user;
	
	@GET
	@Path("/get/{userId}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("userId") String userId, @PathParam("password") String password) {
		
		System.out.println(userId + " ------ " + password);
		
//		userService = new UserService();
		EmployeeUser user = userService.getUser(userId);
		UserStatusModal userStatusresponse = new UserStatusModal();

		/*
		 * if (user != null) { userStatusresponse.setStatus(200);
		 * userStatusresponse.setMessage("User info"); userStatusresponse.setUser(user);
		 * } else { userStatusresponse.setStatus(205);
		 * userStatusresponse.setMessage("No User info"); }
		 */
		
		return Response.ok(user).build();
	}

	
	@POST
	@Path("/create/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String saveUser(@PathParam("userId") String userId, String password) throws SQLException {
		
		System.out.println(userId + " ------ " + password);
		EmployeeUser user = new EmployeeUser();
		user.setPassword(password);
		user.setUserId(userId);
		
//		userService = new UserService();
		String response = userService.saveUser(user);
		

		/*
		 * if (user != null) { userStatusresponse.setStatus(200);
		 * userStatusresponse.setMessage("User info"); userStatusresponse.setUser(user);
		 * } else { userStatusresponse.setStatus(205);
		 * userStatusresponse.setMessage("No User info"); }
		 */
		
		return response;
	}
	
	
}
