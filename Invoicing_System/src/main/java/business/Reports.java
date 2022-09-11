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

import model.Invoice;
import model.Product;



/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/Reports")
public class Reports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		List<Invoice> list = new ArrayList<Invoice>();
		String id = request.getParameter("business");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
		PreparedStatement ps = con.prepareStatement("SELECT id,payment_method,name,total,tax FROM Invoice WHERE business_id=?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Invoice invoice=new Invoice(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getFloat(5));
			list.add(invoice);
		}
	
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("invoices.jsp");
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



