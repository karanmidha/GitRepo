package redbus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redbus.model.DaoImpl.PassengerDaoImpl;
import redbus.model.dao.PassengerDao;
import redbus.model.pojo.Passenger;
import redbus.model.pojo.Schedule;


public class PScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session=request.getSession();
		Schedule sh = new Schedule();
		PassengerDao pd = new PassengerDaoImpl();
		sh.setSchId(Integer.parseInt(request.getParameter("schId")));
		List<Passenger> ls= pd.searchPassenger(sh);		 
		session.setAttribute("passengerlist",ls);
		
		response.sendRedirect("./PassengerList.jsp");			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
