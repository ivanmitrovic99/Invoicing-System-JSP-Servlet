package admin;

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
@WebServlet("/AdminReport")
public class AdminReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String pib = request.getParameter("pib");
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		System.out.print(pib);
		System.out.print(date_start);
		System.out.print(date_end);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
	
		
		PreparedStatement ps = con.prepareStatement("SELECT SUM(i.total),SUM(i.tax),b.business_name FROM invoice i JOIN business b ON i.business_id = b.id WHERE date BETWEEN ? AND ? AND b.pib=?;");
		
		ps.setString(1, date_start);
		ps.setString(2, date_end);
		ps.setString(3, pib);
		
		ResultSet rs= ps.executeQuery();
		rs.next();
		float total=rs.getFloat(1);
		float tax=rs.getFloat(2);
		String name=rs.getString(3);
		request.setAttribute("total", total);
		request.setAttribute("tax", tax);
		request.setAttribute("name", name);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminreport.jsp");
         rd.forward(request, response);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}



