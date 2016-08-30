package redbus.model.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import redbus.model.connection.MyDBConnection;
import redbus.model.dao.BookingDao;
import redbus.model.pojo.Booking;

public class BookingDaoImpl implements BookingDao{


	PreparedStatement pstmt;
	int status;	
	private int seats_booked_by_passenger;
	private int busnum_of_passenger;
	
	public int bookTicket(Booking b) {
		Connection con=null;
		int status=0;
		try{
			con = MyDBConnection.getConnection();
			if(con!=null){
				System.out.println("After Connection Is Created");
				pstmt=con.prepareStatement("insert into booking values(?,?,?,?,?,?) ");
				
				pstmt.setInt(1, b.getBookingPnr());						
				pstmt.setInt(2, b.getBusNum());
				pstmt.setInt(3, b.getPid());				
				pstmt.setInt(4,b.getSchId());
				pstmt.setInt(5, b.getSeatsBooked());
				pstmt.setString(6, b.getStatus());
				System.out.println("Booking:"+b);
				System.out.println(pstmt);
				int rows = pstmt.executeUpdate();
				if(rows>0){
					status = 1;	
				}else{
					status=0;
				}
			}else{
				System.out.println("Connection Not Created");
			}
		}catch(SQLException exp){
//			System.out.println("-------------------------------Connection Not Created-----------------------------------");
			exp.printStackTrace();					
		}
		finally{			
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return status;
	
	}

	public int modifyCancel(Booking b) {
		Connection con=null;
		int status=0;
		int rows=0;
		try{
			con=MyDBConnection.getConnection();
			pstmt=con.prepareStatement("update booking set status=? where pnr=?");
		    pstmt.setString(1,b.getStatus());
		    pstmt.setInt(2, b.getBookingPnr());		    
		    rows = pstmt.executeUpdate();
		    if(rows>0){
		    	status =1;
		    }else{
		    	status=0;
		    }
		    
		}
		catch(SQLException exp){
			exp.printStackTrace();					
		}
		finally{			
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return status;
	}

	public int getSeatsBooked(int pnr) {
		Connection con=null;
		try{
			con= MyDBConnection.getConnection();
			pstmt=con.prepareStatement("select seats_booked from booking where pnr=?"); /* Seats can be updated on basis of only sh_id because there will be multiple buses with different sh_id*/
			pstmt.setInt(1, pnr);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				seats_booked_by_passenger = rs.getInt(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return seats_booked_by_passenger;
	}

	public int getBusNumber(int pnr) {
		Connection con=null;
		try{
			con= MyDBConnection.getConnection();
			pstmt=con.prepareStatement("select b_no from booking where pnr=?"); /* Seats can be updated on basis of only sh_id because there will be multiple buses with different sh_id*/
			pstmt.setInt(1, pnr);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				busnum_of_passenger = rs.getInt(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return busnum_of_passenger;	
	}

	public List<Booking> viewHistory(Booking bo) {
		Connection con=null;
		Booking boNew;
		List<Booking> ls=null;
		
		try{
			con= MyDBConnection.getConnection();
			pstmt=con.prepareStatement("select * from booking where p_id=?");
			pstmt.setInt(1, bo.getPid());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
			boNew = new Booking();
			boNew.setBookingPnr(rs.getInt(1));
		    boNew.setPid(rs.getInt(2));		    
		    boNew.setBusNum(rs.getInt(3));
		    boNew.setSchId(rs.getInt(4));
		    boNew.setSeatsBooked(rs.getInt(5));
		    boNew.setStatus(rs.getString(6));
		    ls= new ArrayList<Booking>();
		    ls.add(boNew);
			}
		}
		catch(SQLException e){
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

}
