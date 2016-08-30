package redbus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redbus.model.DaoImpl.PassengerDaoImpl;
import redbus.model.dao.PassengerDao;
import redbus.model.pojo.Passenger;


public class PassengerDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		List<Passenger> ls = new ArrayList<Passenger>();
		PassengerDao pd= new PassengerDaoImpl();
		ls=pd.searchPassenger();
		session.setAttribute("passengerSearch",ls);
		response.sendRedirect("./PassengerDisplayNormal.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
