package bank.controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.BankDao;
import bank.dao.BankDaoImpl;
import bank.model.Register;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		// TODO Auto-generated method stub
		int accNumber=Integer.parseInt(request.getParameter("accNumber"));
		String accFname=request.getParameter("accFname");
		String accUname=request.getParameter("accUname");
		String accPassword=request.getParameter("accPassword");
		float accBal=Float.parseFloat(request.getParameter("accBal"));
		
		
	
		Register regmodel = new Register(accNumber,accFname,accUname,accPassword,accBal);
		
		
		List<Register> lst = new ArrayList<Register>();
		lst.add(regmodel);
		
		BankDao bdao = new BankDaoImpl();
		
		
		int i=bdao.createAccount(lst);
		if(i>0) {
			//response.sendRedirect();
			
			response.sendRedirect("LoginView.html");
		}
		
		else {
			response.sendRedirect("errorView.html");
		}
		
		
			
	}

}
