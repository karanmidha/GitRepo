package redbus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redbus.model.DaoImpl.PassengerDaoImpl;
import redbus.model.dao.PassengerDao;
import redbus.model.pojo.Passenger;

/**
 * Servlet implementation class InsertPassengerController
 */
public class InsertPassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Passenger p = new Passenger();
		PassengerDao pd= new PassengerDaoImpl();
		int pid=pd.getMaxPid();
		p.setpassengerAdd(request.getParameter("userAdd"));
		p.setpassengerName(request.getParameter("userName"));
		p.setpassengerpPswrd(request.getParameter("userPass"));
		Long phnNum=Long.parseLong(request.getParameter("userPno"));
		
		if(phnNum>=1000000000 && phnNum<=9999999999L){
		p.setpassengerPhone(Long.parseLong(request.getParameter("userPno")));		
		p.setpassengerId(pid+100);
		Passenger preturn = pd.insertPassenger(p);
		session.setAttribute("userId", (pid+100));
		session.setAttribute("insertpassenger", preturn);
		String msg="You Have Been Registered With Id:"+ (pid+100);
		session.setAttribute("Message", msg);
		response.sendRedirect("./UserMessageJSP.jsp");
		}else{
		String msg="Please Enter 10 digit Phone Number";
		session.setAttribute("Message", msg);
		response.sendRedirect("./PhnNumError.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
