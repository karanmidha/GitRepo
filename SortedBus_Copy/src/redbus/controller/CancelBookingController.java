package redbus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redbus.model.DaoImpl.BookingDaoImpl;
import redbus.model.DaoImpl.BusDaoImpl;
import redbus.model.dao.BookingDao;
import redbus.model.dao.BusDao;
import redbus.model.pojo.Booking;
import redbus.model.pojo.Bus;


public class CancelBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session=request.getSession();
		BookingDao bd = new BookingDaoImpl();
		Booking b = new Booking();
		b.setBookingPnr(Integer.parseInt(request.getParameter("deletePnr")));
		int breturn=bd.modifyCancel(b);
		session.setAttribute("cancelBus", breturn);
//		response.sendRedirect("./");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
