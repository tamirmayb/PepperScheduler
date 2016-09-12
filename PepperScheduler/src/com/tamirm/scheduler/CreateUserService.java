package com.tamirm.scheduler;

/**
 * @author Tamir Mayblat
 * This servlet takes userName and emailAddress and sends them as arguments to CreateUser
 * 
 * Example: http://localhost:8080/FIDO/exchange?date=2012-01-03&from=USD&to=ILS,CAD
 */

import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateUser")
public class CreateUserService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateUserService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String emailAddress = request.getParameter("emailAddress");
		CreateUser.createUserFromParams(userName, emailAddress);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
