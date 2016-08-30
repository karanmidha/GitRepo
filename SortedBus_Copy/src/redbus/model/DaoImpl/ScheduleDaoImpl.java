package redbus.model.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import redbus.model.connection.MyDBConnection;
import redbus.model.dao.ScheduleDao;
import redbus.model.pojo.Schedule;

public class ScheduleDaoImpl implements ScheduleDao {

	   private PreparedStatement pstmt;
	   private int schId;
	   private String busDate;
	   private JdbcTemplate jdbctemplate;
	   
	public int insertSchedule(Schedule sh) throws SQLException {
		
		String query="insert into schedule values (?,?,?,?,?)";
		int i = jdbctemplate.update(query, new Object[]{sh.getSchId(),sh.getBusNum(),sh.getVacantSeats()
		
//		Connection con=null;
//		System.out.println(sh);
//		con=MyDBConnection.getConnection();
//		pstmt=con.prepareStatement("insert into schedule values (?,?,?,?,?)");
//
//		pstmt.setInt(1,sh.getSchId() );
//		pstmt.setInt(2,sh.getBusNum());
//		pstmt.setInt(3,sh.getVacantSeats());			
//		pstmt.setString(4,sh.getSchDate());
//		pstmt.setString(5,sh.getSchTime());
//		rows = pstmt.executeUpdate();			
//		con.close();
//	if(rows>0){
//		return 1;
//	}
//	return 0;
	}

	public List<Schedule> search(Schedule sh) {
			
		String query= "select s_id,b_no,seats,b_date, time from schedule where s_id=?";	
		return jdbctemplate.query(query, new Object[]{sh.getSchId()},new RowMapper<Schedule>(){
			
			@Override
			public Schedule mapRow(ResultSet rs, int rownumber) throws SQLException {
								
				while (rs.next()){
				sh.setSchId(rs.getInt(1));
				sh.setBusNum(rs.getInt(2));
				sh.setVacantSeats(rs.getInt(3));
				sh.setSchDate(rs.getString(4));			
				sh.setSchTime(rs.getString(5));
				return sh;				
				}
		}
//		Connection con=null;
//		List<Schedule> ls = new ArrayList<Schedule>();
//		try{
//			con=MyDBConnection.getConnection();
//			pstmt=con.prepareStatement("select s_id,b_no,seats,b_date, time from schedule where s_id=?");
//			pstmt.setInt(1, sh.getSchId());
//			ResultSet rs=pstmt.executeQuery();
//			
//			while(rs.next()){
//				int s_id=rs.getInt(1); //check
//				int b_no= rs.getInt(2);
//				int seat=rs.getInt(3);
//				String date1=rs.getString(4);
//				String timing=rs.getString(5);				
//				
//				sh.setSchId(s_id);
//				sh.setBusNum(b_no);
//				sh.setVacantSeats(seat);
//				sh.setSchDate(date1);			
//				sh.setSchTime(timing);
//				ls.add(sh);
//			}
//		}
//		catch(SQLException exp){
//			exp.printStackTrace();
//		}
//		finally{			
//			try {
//				con.close();
//			} catch (SQLException e) {				
//				e.printStackTrace();
//			}
//		}
//		return ls;
		}

	public void seatsIncrement(Schedule sh) {
		
		String query="update schedule set seats=? where b_no=?";
		jdbctemplate.update(query, new Object[]{sh.getVacantSeats(),sh.getBusNum()});
	}
//		Connection con=null;
////		seatsLeft=seatsLeft+seats;
//		try{
//			con= MyDBConnection.getConnection();
//			pstmt=con.prepareStatement("update schedule set seats=? where b_no=?");
//			pstmt.setInt(1, sh.getVacantSeats());// seats will be set when a booking is made using setseats()
//			pstmt.setInt(2, sh.getBusNum());
//		    pstmt.execute();
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	}
	

	public void seatsDecrement(Schedule sh) {      /*Function to modify seats whenever a booking is made*/
		
		String query="update schedule set seats=? where s_id=?";
		jdbctemplate.update(query, new Object[]{sh.getVacantSeats(),sh.getSchId()});
	}
//		seatsLeft=seatsLeft-seats;
//		Connection con=null;
//		try{
//			con= MyDBConnection.getConnection();
//			if(con!=null){
//				System.out.println("In if block");
//			pstmt=con.prepareStatement("update schedule set seats=? where s_id=?"); /* Seats can be updated on basis of only sh_id because there will be multiple buses with different sh_id*/
//			pstmt.setInt(1, sh.getVacantSeats());
//			pstmt.setInt(2, sh.getSchId());
//			pstmt.executeUpdate();
//			}else{
//				System.out.println("Not In iffff");
//			}
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public int getScheduleId(int busNum) {
		String query="select s_id from schedule where b_no=?";
		return jdbctemplate.queryForObject(query,new Object[]{busNum},Integer.class);
	}
//		Connection con=null;
//		try{
//			con= MyDBConnection.getConnection();
//			pstmt=con.prepareStatement("select s_id from schedule where b_no=?");
//			pstmt.setInt(1, busNum);
//			ResultSet rs = pstmt.executeQuery();
//			if(rs.next()){
//			schId = rs.getInt(1);
//			}
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return schId;
//	}

	public String getSchDate(int schId) {
		
		String query="select b_date from schedule where s_id=?";
		return jdbctemplate.update(query, new Object[]{schId}, Integer.class);
	}
//		Connection con=null;
//		try{
//			con= MyDBConnection.getConnection();
//			pstmt=con.prepareStatement("select b_date from schedule where s_id=?"); 
//			pstmt.setInt(1, schId);
//			ResultSet rs = pstmt.executeQuery();
//			if(rs.next()){
//			busDate = rs.getString(1);
//			}
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return busDate;	
//	}

	public int getMinVacantSeats() {
		
	}
		String query="select Min(Seats) from schedule";
		return jdbctemplate.update(query, Integer.class); 
	}
//		Connection con=null;
//		int minVacantSeat=0;
//		try{
//			con= MyDBConnection.getConnection();
//			pstmt=con.prepareStatement("select Min(Seats) from schedule"); 			
//			ResultSet rs = pstmt.executeQuery();
//			if(rs.next()){
//				minVacantSeat=rs.getInt(1);
//			}
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}		
//		return minVacantSeat;
//	}

}
