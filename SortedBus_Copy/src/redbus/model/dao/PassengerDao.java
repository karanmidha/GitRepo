package redbus.model.dao;

import java.util.List;

import redbus.model.pojo.Booking;
import redbus.model.pojo.Passenger;
import redbus.model.pojo.Schedule;

public interface PassengerDao {
//The pId will be generated using a for loop at the time of sign up. The value of pId will be kept as static.
	public Passenger insertPassenger(Passenger p);// Includes implicit calling to a function that generates PID. This PID value will be used in the Passenger class by using getter function.
	public Passenger signIn(Passenger p); 

	public Booking history(Booking b); //Shows the travel history
	public List<Passenger> searchPassenger(); // Booking will be made by entering the BusId. First search function will run then the user can book the bus by entering the busId.
	public void book(Booking bo); //generate ScheduleId within the book function to store the Id value in Schedule table.Make the Schedule ID static.
	public List<Passenger> searchPassenger(Schedule sc);
	public int getMaxPid();
}


//HAVEN'T INCLUDED THE FUNCTION FOR COUPON AND TRANSACTION. 