package bank.model;

public class Register {
	private int accNumber;
	private String accFname;
	private String accUname;
	private String password;
	private float accBal;
	public Register() {
		
	}
	public Register(int accNumber, String accFname, String accUname, String password, float accBal) {
		super();
		this.accNumber = accNumber;
		this.accFname = accFname;
		this.accUname = accUname;
		this.password = password;
		this.accBal = accBal;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccFname() {
		return accFname;
	}
	public void setAccFname(String accFname) {
		this.accFname = accFname;
	}
	public String getAccUname() {
		return accUname;
	}
	public void setAccUname(String accUname) {
		this.accUname = accUname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getAccBal() {
		return accBal;
	}
	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	


}
