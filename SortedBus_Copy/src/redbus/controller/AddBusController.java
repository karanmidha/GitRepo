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
 * Servlet implementation class AddBusController
 */
public class AddBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		BusDao bd = new BusDaoImpl();
		Bus b = new Bus();
		b.setBusNumber(Integer.parseInt(request.getParameter("numAdd")));
		b.setBusSource(request.getParameter("sourceAdd"));
		b.setBusDestination(request.getParameter("destAdd"));
		Bus breturn = bd.addBus(b);
		session.setAttribute("addedBus", breturn);
		String msg="Bus With Bus Number "+Integer.parseInt(request.getParameter("numAdd"))+" Is Added";
		session.setAttribute("Message", msg);
		
		response.sendRedirect("./AdminMessageJSP.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
