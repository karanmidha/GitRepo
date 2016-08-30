package redbus.model.pojo;

public class Booking {

	private int bookingPnr;
	private int pid;
	private int busNum;
	private int schId;
	private int seatsBooked;
	private String status;	
	
	
	

	public Booking(int bookingPnr, int pid, int busNum, int schId, int seatsBooked, String status, int bookingSeats,
			String bookingStatus) {
		super();
		this.bookingPnr = bookingPnr;
		this.pid = pid;
		this.busNum = busNum;
		this.schId = schId;
		this.seatsBooked = seatsBooked;
		this.status = status;
		
	}
	public Booking(){
		
	}
	
	@Override
	public String toString() {
		return "Booking [bookingPnr=" + bookingPnr + ", pid=" + pid + ", busNum=" + busNum + ", schId=" + schId
				+ ", seatsBooked=" + seatsBooked + ", status=" + status + "]";
	}
	
	
	public int getBookingPnr() {
		return bookingPnr;
	}
	public void setBookingPnr(int bookingPnr) {
		this.bookingPnr = bookingPnr;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getBusNum() {
		return busNum;
	}
	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}
	public int getSchId() {
		return schId;
	}
	public void setSchId(int schId) {
		this.schId = schId;
	}
	public int getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
