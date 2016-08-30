package redbus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redbus.model.DaoImpl.BusDaoImpl;
import redbus.model.dao.BusDao;
import redbus.model.pojo.Bus;
import redbus.model.pojo.Schedule;


public class SearchBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		List<Bus> ls = new ArrayList<Bus>();
		char dest[];
		Bus bus= new Bus();
		Schedule sch= new Schedule();
		BusDao bd = new BusDaoImpl();
		int date=Integer.parseInt(request.getParameter("schDate"));
		
		String month= request.getParameter("schMonth");
	    dest = new char[10];
		month.getChars(0, 3,dest, 0);
		
		month=dest[0]+""+dest[1]+""+dest[2];
		month=month.toUpperCase();
		int year= Integer.parseInt(request.getParameter("schYear"));
	    String date_final=date+"-"+month+"-"+year;
	    sch.setSchDate(date_final);
		
		bus.setBusDestination(request.getParameter("destination"));
		
		bus.setBusSource(request.getParameter("source"));
		
		ls=bd.searchBus(bus, sch);
		System.out.println("asd");
		if(ls!=null){
		session.setAttribute("searchBusList",ls);				
		response.sendRedirect("./BusList.jsp");
		}else{
			System.out.println("does not exists");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
