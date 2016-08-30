package redbus.model.dao;

import java.util.List;

import redbus.model.pojo.*;

public interface BookingDao {

//	public int generatePnr();
	
	public int bookTicket(Booking b);// dynamic entry into the table. The value of PNR will be taken from the
                         // above function and will be inserted into this function
	
	public int modifyCancel(Booking b);//Update the status of the booking if a user cancels his or her ticket
	public int getSeatsBooked(int pnr);
	public int getBusNumber(int pnr);
	public List<Booking> viewHistory(Booking bo);
}
