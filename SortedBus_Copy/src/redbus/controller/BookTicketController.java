package redbus.controller;

import java.io.IOException;
import java.util.Random;

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
 * Servlet implementation class BookTicketController
 */
public class BookTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int pnr=0;
		int bookTicketStatus=0;
		Random r = new Random();
		ScheduleDao sd = new ScheduleDaoImpl();
					
		
		try{
		Booking b = new Booking();
		BookingDao bd = new BookingDaoImpl();
		pnr=r.nextInt(1000);
		
		b.setBusNum(Integer.parseInt(request.getParameter("busNum")));
		b.setSeatsBooked(Integer.parseInt(request.getParameter("seatsBooked")));
		b.setBookingPnr(pnr);
		b.setSchId(sd.getScheduleId(Integer.parseInt(request.getParameter("busNum"))));
		b.setStatus("Booked");
		b.setPid((Integer)session.getAttribute("userId"));
		System.out.println(b);
		
		
		bookTicketStatus = bd.bookTicket(b);
		session.setAttribute("bookTicketStatus", bookTicketStatus);
		}catch(Exception exp){
			exp.printStackTrace();
		}
		if(bookTicketStatus == 1){
			String msg="Your ticket has been booked And Your PNR Is "+pnr;
			session.setAttribute("Message", msg);
			ScheduleDao sd1 = new ScheduleDaoImpl();
			int presentMinSeats=sd1.getMinVacantSeats();
			Schedule sch = new Schedule();
			int schId = sd1.getScheduleId(Integer.parseInt(request.getParameter("busNum")));
			sch.setSchId(schId);
			sch.setVacantSeats(presentMinSeats-Integer.parseInt(request.getParameter("seatsBooked")));		
			sd1.seatsDecrement(sch);
			response.sendRedirect("./MainUserMessage.jsp");
		}else{
			String msg="Not Booked";
			session.setAttribute("Message", msg);
			response.sendRedirect("./MainUserMessage.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
