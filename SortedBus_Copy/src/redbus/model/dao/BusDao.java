package redbus.model.dao;

import java.util.List;

import redbus.model.pojo.Bus;
import redbus.model.pojo.Schedule;

public interface BusDao {
// adding a comment
	public Bus addBus(Bus b);
	public int deleteBus(Bus b);
	public List<Bus> searchBus(Bus b,Schedule s);//will be initialized when user opts for booking a bus from the main menu
	public List<Bus> displayAll();//Admin control. not visible to the user
	public Bus getBusDetails(int busNum);
}
