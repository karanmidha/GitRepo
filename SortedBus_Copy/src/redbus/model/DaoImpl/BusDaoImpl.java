package redbus.model.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import redbus.model.connection.MyDBConnection;
import redbus.model.dao.BusDao;
import redbus.model.pojo.Bus;
import redbus.model.pojo.Schedule;

public class BusDaoImpl implements BusDao {

	private Connection con;
	private PreparedStatement pstmt;	
	Bus bs;
	int row;
	public Bus addBus(Bus b) {
		System.out.println(b.getBusNumber()+" "+b.getBusSource()+" "+b.getBusDestination());
		bs = new Bus();
	
		try{
			con=MyDBConnection.getConnection();
			if(con!=null){
				pstmt=con.prepareStatement("insert into bus values (?,?,?)");
				pstmt.setInt(1,b.getBusNumber());
				pstmt.setString(2, b.getBusSource().toUpperCase());
				pstmt.setString(3, b.getBusDestination().toUpperCase());
				row=pstmt.executeUpdate();
				//System.out.println(row);
				if(row>0){
					//System.out.println("Entering in loop...");
					bs.setBusNumber(b.getBusNumber());
					bs.setBusSource(b.getBusSource());
					bs.setBusDestination(b.getBusDestination());				
				}
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
//		System.out.println(bs.getBusNumber()+" "+bs.getBusSource()+" "+bs.getBusDestination());
		return bs;
	}

	public int deleteBus(Bus b) {
		int status=0;
		int passId=0;
		try{
			con=MyDBConnection.getConnection();
			
			//Getting pid corresponding to bus number from booking table to delete entry from passenger table...
			pstmt=con.prepareStatement("select p_id from booking where b_no=?");
			pstmt.setInt(1, b.getBusNumber());
			ResultSet rs =pstmt.executeQuery();
			if(rs.next()){
			passId=rs.getInt(1);
			}
			
			//deleting entry from booking table.. 
			pstmt=con.prepareStatement("delete from booking where b_no=?");
			pstmt.setInt(1, b.getBusNumber());
			row =pstmt.executeUpdate();
//			System.out.println("Entry from booking table deleted"+ row);
			
			//deleting entry from passenger table
			pstmt=con.prepareStatement("delete from passenger where p_id=?");
			pstmt.setInt(1, passId);
			row =pstmt.executeUpdate();
//			System.out.println("Entry from passenger table deleted"+ row);
			
			//deleting entry from schedule table
			pstmt=con.prepareStatement("delete from schedule where b_no=?");
			pstmt.setInt(1, b.getBusNumber());
			row =pstmt.executeUpdate();
//			System.out.println("Entry from schedule table deleted"+ row);
						
			pstmt=con.prepareStatement("delete from bus where b_no=?");
			pstmt.setInt(1,b.getBusNumber());
			row =pstmt.executeUpdate();
			if(row>0){
				status=1;
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

	public List<Bus> searchBus(Bus b, Schedule s) {
		List<Bus> ls = new ArrayList<Bus>();
		Bus bNew;
		try{
			con=MyDBConnection.getConnection();
			pstmt=con.prepareStatement("select b.b_no,b.source,b.destination from bus b join schedule s on b.source=? and b.destination=? and s.b_date=?");
			pstmt.setString(1, b.getBusSource().toUpperCase());
			pstmt.setString(2, b.getBusDestination().toUpperCase());
			pstmt.setString(3, s.getSchDate());
			ResultSet rs = pstmt.executeQuery();
//			Bus bs = new Bus(); b object uded for search and bs used for setting..
			while(rs.next()){
				bNew = new Bus(); 
				bNew.setBusNumber(rs.getInt(1));
				bNew.setBusDestination(rs.getString(2));
				bNew.setBusSource(rs.getString(3));								
				ls.add(bNew);
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
		return ls;
	}

	public List<Bus> displayAll() {
		List<Bus> ls = new ArrayList<Bus>();
		try{
			con=MyDBConnection.getConnection();
			pstmt=con.prepareStatement("select * from bus");
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()){
				Bus b = new Bus();				
				
				int bno=rs.getInt(1);
				String src=rs.getString(2);
				String dest=rs.getString(3);				
				
				b.setBusNumber(bno);
				b.setBusDestination(dest);
				b.setBusSource(src);				
				
				ls.add(b);
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
		return ls;
	}

	public Bus getBusDetails(int busNum) {
		bs = new Bus();
		try{
			con=MyDBConnection.getConnection();
			pstmt=con.prepareStatement("select * from bus where b_no=?");
			pstmt.setInt(1, busNum);
			ResultSet rs =pstmt.executeQuery();
			if(rs.next()){																					
				bs.setBusNumber(rs.getInt(1));
				bs.setBusDestination(rs.getString(2));
				bs.setBusSource(rs.getString(3));												
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
		return bs;
	}

}
