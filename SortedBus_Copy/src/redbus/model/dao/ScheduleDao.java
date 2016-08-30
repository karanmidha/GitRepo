package redbus.model.dao;


import java.sql.SQLException;
import java.util.List;
import redbus.model.pojo.Schedule;

public interface ScheduleDao {

	public int insertSchedule(Schedule sh) throws SQLException;//Dynamic input into the table whenever a person makes a booking
	public List<Schedule>search(Schedule sh);
	public void seatsIncrement(Schedule sh);//used when a person cancels his booking.Adds seats to seats column.
	public void seatsDecrement(Schedule sh);
	public int getScheduleId(int busNum);
	public String getSchDate(int schId);
	public int getMinVacantSeats();
}
