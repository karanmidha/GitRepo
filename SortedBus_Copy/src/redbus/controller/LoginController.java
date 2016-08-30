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
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Passenger ps = new Passenger();
		PassengerDao pd = new PassengerDaoImpl();		
		
			if(Integer.parseInt(request.getParameter("LoginId")) == 999 && request.getParameter("LoginPassword").equals("admin") ){
				System.out.println("Admin Enter");
				response.sendRedirect("./AdminMainPage.jsp");
			}else{
				
				int userId=Integer.parseInt(request.getParameter("LoginId"));
				ps.setpassengerId(userId);
				ps.setpassengerpPswrd(request.getParameter("LoginPassword"));
				Passenger psreturn = pd.signIn(ps);
				if(psreturn!=null){
					session.setAttribute("userId", userId);
					String msg="You have successfully logged in!! ";
					session.setAttribute("Message", msg);
					session.setAttribute("passengerReturn", psreturn);				
					response.sendRedirect("./MainUserMessage.jsp");
				}else{
					String msg="Not valid Username Password ";
					session.setAttribute("Message", msg);							
					response.sendRedirect("./InvalidUsPass.jsp");
				}
			}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
