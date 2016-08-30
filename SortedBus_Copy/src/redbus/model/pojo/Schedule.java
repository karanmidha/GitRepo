package redbus.model.pojo;



public class Schedule {
		
//	java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	private int vacantSeats;
	private String schDate;
	private int busNum;
	private int schId;
	private String schTime;
	
	public Schedule(){
		
	}
	
	public Schedule(int vacantSeats, String schDate, int busNum, int schId, String schTime) {
		super();
		this.vacantSeats = vacantSeats;
		this.schDate = schDate;
		this.busNum = busNum;
		this.schId = schId;
		this.schTime = schTime;
	}
	
	@Override
	public String toString() {
		return "Schedule [vacantSeats=" + vacantSeats + ", schDate=" + schDate + ", busNum=" + busNum + ", schId="
				+ schId + ", schTime=" + schTime + "]";
	}
	
	
	public int getVacantSeats() {
		return vacantSeats;
	}
	
	public void setVacantSeats(int vacantSeats) {
		this.vacantSeats = vacantSeats;
	}
	public String getSchDate() {
		return schDate;
	}
	public void setSchDate(String schDate) {
		this.schDate = schDate;
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
	
	public String getSchTime() {
		return schTime;
	}
	public void setSchTime(String schTime) {
		this.schTime = schTime;
	}
	
	
	
}
