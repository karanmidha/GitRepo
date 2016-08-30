package redbus.model.pojo;

public class Passenger {

	private int passengerId;
	private String passengerName;
	private String passengerAdd;
	private long passengerPhone;
	private String passengerpPswrd;


	public Passenger(){
		
	}
	
	public Passenger(int passengerId, String passengerName, String passengerAdd, int passengerPhone,
			String passengerpPswrd) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerAdd = passengerAdd;
		this.passengerPhone = passengerPhone;
		this.passengerpPswrd = passengerpPswrd;
		}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerAdd="
				+ passengerAdd + ", passengerPhone=" + passengerPhone + ", passengerpPswrd=" + passengerpPswrd+"]";
	}

	public int getpassengerId() {
		return passengerId;
	}

	public void setpassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getpassengerName() {
		return passengerName;
	}

	public void setpassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getpassengerAdd() {
		return passengerAdd;
	}

	public void setpassengerAdd(String passengerAdd) {
		this.passengerAdd = passengerAdd;
	}

	public long getpassengerPhone() {
		return passengerPhone;
	}

	public void setpassengerPhone(long phnNo) {
		this.passengerPhone = phnNo;
	}

	public String getpassengerpPswrd() {
		return passengerpPswrd;
	}

	public void setpassengerpPswrd(String passengerpPswrd) {
		this.passengerpPswrd = passengerpPswrd;
	}
	
	
}
