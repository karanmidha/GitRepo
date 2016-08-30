package redbus.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redbus.model.DaoImpl.ScheduleDaoImpl;
import redbus.model.dao.ScheduleDao;
import redbus.model.pojo.Schedule;

/**
 * Servlet implementation class AddScheduleController
 */
public class AddScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int shreturn=0;
		Schedule sh = new Schedule();
		ScheduleDao sd = new ScheduleDaoImpl();
		sh.setVacantSeats(Integer.parseInt(request.getParameter("busseats")));
		sh.setSchId(Integer.parseInt(request.getParameter("schId")));
		sh.setSchTime(request.getParameter("time"));
		
		
		int date=Integer.parseInt(request.getParameter("dot"));		
		String month= request.getParameter("mon");
	    char dest[] = new char[10];
		month.getChars(0, 3,dest, 0);		
		month=dest[0]+""+dest[1]+""+dest[2];
		month=month.toUpperCase();
		int year= Integer.parseInt(request.getParameter("yr"));
	    String date_final=date+"-"+month+"-"+year;	    
	    sh.setSchDate(date_final);		
	
		sh.setBusNum(Integer.parseInt(request.getParameter("busNum")));
		try{
		shreturn = sd.insertSchedule(sh);
		}catch(SQLException exp){
			exp.printStackTrace();
		}		
		session.setAttribute("addsheduleStatus",shreturn);
		String msg="Schedule With Schedule Id "+Integer.parseInt(request.getParameter("schId"))+" Is Added";
		session.setAttribute("Message", msg);			
		response.sendRedirect("./AdminMessageJSP.jsp");
//		response.sendRedirect("./");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
