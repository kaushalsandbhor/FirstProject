package bank.dao;

import java.util.List;

import bank.model.Register;

public interface BankDao {
	public int createAccount(List<Register> rlist);
	public int loginAccount(String accUserId,String accPass);
	public List<Register> displayAll();
	public int deleteRecord(int accNumber);
	public List<Register> serachRecord(int accNumber);

	
}
