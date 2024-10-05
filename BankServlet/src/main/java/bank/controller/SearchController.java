package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.BankDao;
import bank.dao.BankDaoImpl;
import bank.model.Register;


@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int accNumber = Integer.parseInt(request.getParameter("accNumber"));
		BankDao bdao = new BankDaoImpl();
		List<Register> lst=null;
		lst=bdao.serachRecord(accNumber);
		Register r = lst.get(0);
		
		PrintWriter pw = response.getWriter();
		
		if(lst!=null) {
			pw.println(r.getAccNumber()+"\t"+r.getAccFname()+"\t"+r.getAccBal());
		}
		
		else{
			response.sendRedirect("ErrorView.html");
		}
		
	 
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
