package redbus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redbus.model.DaoImpl.BusDaoImpl;
import redbus.model.dao.BusDao;
import redbus.model.pojo.Bus;

/**
 * Servlet implementation class DeleteBusController
 */
public class DeleteBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		 Bus bus=new Bus();
		 bus.setBusNumber(Integer.parseInt(request.getParameter("DeleteBus")));
		 BusDao bs= new BusDaoImpl();
		 int status = bs.deleteBus(bus);
		 session.setAttribute("deletedBusStatus",status);
		 
		 String msg="Bus With Bus Number "+Integer.parseInt(request.getParameter("DeleteBus"))+ " Is Deleted";
		 session.setAttribute("Message", msg);			
		 response.sendRedirect("./AdminMessageJSP.jsp");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
