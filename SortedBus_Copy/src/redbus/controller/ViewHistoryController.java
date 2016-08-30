package redbus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import redbus.model.DaoImpl.BookingDaoImpl;
import redbus.model.dao.BookingDao;
import redbus.model.pojo.Booking;

/**
 * Servlet implementation class ViewHistoryController
 */
public class ViewHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		BookingDao bd = new BookingDaoImpl();
		Booking b = new Booking();
		b.setPid((int)session.getAttribute("userId"));
		List<Booking> ls = bd.viewHistory(b);
		session.setAttribute("historyList", ls);
		
		response.sendRedirect("./HistoryList.jsp");		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
