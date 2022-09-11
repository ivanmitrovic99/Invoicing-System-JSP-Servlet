package business;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;



/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/MoneyReport")
public class MoneyReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String date = request.getParameter("date");
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
	
		PreparedStatement ps = con.prepareStatement("SELECT total,tax FROM invoice WHERE date=?");
		ps.setString(1, date);
		float total=0;
		float tax=0;
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			total=total+rs.getFloat(1);
			tax=tax+rs.getFloat(2);
		}
	
		request.setAttribute("total", total);
		request.setAttribute("tax", tax);
		request.setAttribute("date", date);
		RequestDispatcher rd = request.getRequestDispatcher("moneyreport.jsp");
         rd.forward(request, response);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}}
	
		
	



