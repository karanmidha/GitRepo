package redbus.model.pojo;

public class Bus {

	private int busNumber;
	private String busSource;
	private String busDestination;
	
	public Bus(){
		
	}
	
	public Bus(int busNumber, String busSource, String busDestination) {
		this.busNumber = busNumber;
		this.busSource = busSource;
		this.busDestination = busDestination;
	}

	@Override
	public String toString() {
		return "Bus [busNumber=" + busNumber + ", busSource=" + busSource + ", busDestination=" + busDestination + "]";
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusSource() {
		return busSource;
	}

	public void setBusSource(String busSource) {
		this.busSource = busSource;
	}

	public String getBusDestination() {
		return busDestination;
	}

	public void setBusDestination(String busDestination) {
		this.busDestination = busDestination;
	}


}
