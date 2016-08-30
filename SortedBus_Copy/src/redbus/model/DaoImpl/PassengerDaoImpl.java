package redbus.model.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import redbus.model.connection.MyDBConnection;
import redbus.model.dao.PassengerDao;
import redbus.model.pojo.Booking;
import redbus.model.pojo.Passenger;
import redbus.model.pojo.Schedule;

public class PassengerDaoImpl implements PassengerDao {

	private PreparedStatement pstmt;
	Passenger p;	
	int rows;
	int maxPid;
	public Passenger insertPassenger(Passenger p) {
		Connection con=null;
		PreparedStatement pstmt;
		Passenger ps =null;
		try{
			ps= new Passenger();
			con=MyDBConnection.getConnection();
			pstmt = con.prepareStatement("INSERT INTO PASSENGER VALUES(?,?,?,?,?)");			
			pstmt.setInt(1, p.getpassengerId());
			pstmt.setString(2, p.getpassengerName());
			pstmt.setString(3, p.getpassengerAdd());
			pstmt.setLong(4, p.getpassengerPhone());
			pstmt.setString(5, p.getpassengerpPswrd());
			rows=pstmt.executeUpdate();
			if(rows>0){
				ps.setpassengerId(p.getpassengerId());
				ps.setpassengerName(p.getpassengerName());
				ps.setpassengerAdd(p.getpassengerAdd());
				ps.setpassengerPhone(p.getpassengerPhone());
				ps.setpassengerpPswrd(p.getpassengerpPswrd());
			}
							
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			try{
			con.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}	
		return ps;
	}

	public Passenger signIn(Passenger p) {
		Connection con;
		PreparedStatement pstmt;
		Passenger ps =null;		
		try{
			
			con=MyDBConnection.getConnection();
			pstmt = con.prepareStatement("select * from passenger where p_id=? and password=?");			
			pstmt.setInt(1,p.getpassengerId());
			pstmt.setString(2, p.getpassengerpPswrd());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){				
			ps = new Passenger();
			ps.setpassengerId(rs.getInt(1));
			ps.setpassengerName(rs.getString(2));
			ps.setpassengerAdd(rs.getString(3));
			ps.setpassengerPhone(rs.getLong(4));
			ps.setpassengerpPswrd(rs.getString(5));
			}
			
		}
		catch(SQLException exp){
			exp.printStackTrace();
		}
		return ps;
	}

	public Booking history(Booking b) {
		PreparedStatement pstmt;
		Connection con=null;					
		try {
			con=MyDBConnection.getConnection();
			pstmt=con.prepareStatement("select b.PNR,b.p_id,b.b_no,b.AMOUNT FROM BOOKING b");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				
				int pId=rs.getInt("P_ID");
				int pnr=rs.getInt("PNR");	
				int busNum=rs.getInt("B_NO");
				
				
														
				
				b.setBookingPnr(pnr);	
				b.setPid(pId);
				b.setBusNum(busNum);						
			}
				} 
			catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
			return b;
	}

	public List<Passenger> searchPassenger() {
		List<Passenger> ls = new ArrayList<Passenger>();
		Connection con=null;			
		Passenger p;
		try{
			con=MyDBConnection.getConnection();			
			pstmt=con.prepareStatement("select * from passenger");			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				p = new Passenger();
				p.setpassengerId(rs.getInt(1));
				p.setpassengerName(rs.getString(2));
				p.setpassengerAdd(rs.getString(3));
		    	p.setpassengerPhone(rs.getLong(4));
		    	p.setpassengerpPswrd(rs.getString(5));
		    	ls.add(p);
				}	
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
		return ls;	
	}

	public void book(Booking bo) {
		Connection con=null;			
		int rows=0;
		try{
			con=MyDBConnection.getConnection();			
			pstmt=con.prepareStatement("insert into BOOKING values (?,?,?,?,?,?)");
			pstmt.setInt(1, bo.getBookingPnr());
			pstmt.setInt(2, bo.getPid());
			pstmt.setInt(3, bo.getBusNum());
			pstmt.setInt(4, bo.getSeatsBooked());
			pstmt.setString(5, bo.getStatus());
		
			rows=pstmt.executeUpdate();
			
			if(rows>0){
				System.out.println("Seat booked successfully");
			}
			else{
				System.out.println("Booking Failed");
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}

	}

	public List<Passenger> searchPassenger(Schedule sc) {
		List<Passenger> ls = new ArrayList<Passenger>();
		Connection con=null;			
		Passenger p;
		try{
			con=MyDBConnection.getConnection();			
			pstmt=con.prepareStatement("select p.p_id,p.name,p.address,p.ph_no from passenger p join booking b on p.p_id=b.p_id and b.s_id=? ");
			pstmt.setInt(1, sc.getSchId());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				p= new Passenger();
				p.setpassengerId(rs.getInt(1));
				p.setpassengerName(rs.getString(2));
				p.setpassengerAdd(rs.getString(3));
		    	p.setpassengerPhone(rs.getLong(4));
		    	ls.add(p);
				}				
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
		return ls;		
	
	}

	public int getMaxPid() {
		Connection con=null;	
		try{
			con=MyDBConnection.getConnection();			
			pstmt=con.prepareStatement("select max(p_id) from passenger");		
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				maxPid=rs.getInt(1);				
				}				
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return maxPid;
	}
	
}


