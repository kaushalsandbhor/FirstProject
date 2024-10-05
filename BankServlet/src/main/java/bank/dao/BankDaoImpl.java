package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bank.model.Register;

public class BankDaoImpl implements BankDao{
	Connection con=null;
	PreparedStatement pstate=null;
	Statement state =null;
	ResultSet result=null;
	@Override
	public int createAccount(List<Register> rlist) {
		con=DBConnection.myConnection();
		Register r = rlist.get(0);
		
		int i=0;

		
		
		try {
			
			pstate=con.prepareStatement("insert into servletBank values (?,?,?,?,?)");
			pstate.setInt(1, r.getAccNumber());
			pstate.setString(2, r.getAccFname());
			pstate.setString(3, r.getAccUname());
			pstate.setString(4, r.getPassword());
			pstate.setFloat(5, r.getAccBal());
			
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}
	@Override
	public int loginAccount(String accUserId, String accPass) {
		con=DBConnection.myConnection();
		// TODO Auto-generated method stub
		int flag=0;
		try {
			pstate=con.prepareStatement("select * from servletBank where acc_uname=? and acc_password=?");
			pstate.setString(1, accUserId);
			pstate.setString(2, accPass);
			result=pstate.executeQuery();
			
			if(result.next()) {
				flag=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	@Override
	public List<Register> displayAll() {
		// TODO Auto-generated method stub
		con=DBConnection.myConnection();
		List<Register> lst = new ArrayList<Register>();
		String str="select * from servletBank";
		try {
			state=con.createStatement();
			result=state.executeQuery(str);
			while(result.next()) {
				lst.add(new Register(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getFloat(5)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	@Override
	public int deleteRecord(int accNumber) {
		// TODO Auto-generated method stub
		con=DBConnection.myConnection();
		int i=0;
		
		try {
			pstate=con.prepareStatement("delete from servletBank where acc_Number =?");
			pstate.setInt(1, accNumber);
			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}
	@Override
	public List<Register> serachRecord(int accNumber) {
		// TODO Auto-generated method stub
		con=DBConnection.myConnection();
		List<Register> lst = new ArrayList<Register>();
		int i=0;
		
		try {
			pstate=con.prepareStatement("select * from servletBank where acc_Number=?");
			pstate.setInt(1, accNumber);
			result=pstate.executeQuery();
			
			if(result.next()) {
				
				lst.add(new Register(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getFloat(5)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return lst;
	}



}
