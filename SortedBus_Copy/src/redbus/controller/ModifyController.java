package redbus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redbus.model.DaoImpl.BookingDaoImpl;
import redbus.model.DaoImpl.ScheduleDaoImpl;
import redbus.model.dao.BookingDao;
import redbus.model.dao.ScheduleDao;
import redbus.model.pojo.Booking;
import redbus.model.pojo.Schedule;

/**
 * Servlet implementation class ModifyController
 */
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		ScheduleDao sd = new ScheduleDaoImpl();
		BookingDao bod = new BookingDaoImpl();
		Booking bo = new Booking();
		int status = 0;
		int presentMinSeats=0;
						
		bo.setStatus("Cancelled");
		int pnrNumber=Integer.parseInt(request.getParameter("deletePnr"));
		bo.setBookingPnr(pnrNumber);
		
		status = bod.modifyCancel(bo);

		if(status == 1){		
			bod = new BookingDaoImpl();
			
		 int seats_booked_by_passenger = bod.getSeatsBooked(pnrNumber);
			System.out.println("Seats Booked  By Passenger Is "+seats_booked_by_passenger);
			
			int busnum_Of_passenger = bod.getBusNumber(pnrNumber);
			System.out.println("Bus Number Of Passenger Is "+busnum_Of_passenger);
			

			presentMinSeats=sd.getMinVacantSeats();
			System.out.println("Minimum seats vacant in schedule table is "+presentMinSeats);
			Schedule sch = new Schedule();
			sch.setVacantSeats(presentMinSeats+seats_booked_by_passenger);
			sch.setBusNum(busnum_Of_passenger);
			
			sd.seatsIncrement(sch);
		
		}else{
			status = 0;
		}
		session.setAttribute("cancelledPnr", status);
		String msg="Your Ticket Has Benn Cancelled!!";
		session.setAttribute("Message", msg);
		response.sendRedirect("./MainUserMessage.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
