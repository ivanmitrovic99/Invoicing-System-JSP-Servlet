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
@WebServlet("/AddInvoice")
public class AddInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String name = request.getParameter("name");
		String products= request.getParameter("products");
		String quantities = request.getParameter("quantities");
		float total =Float.parseFloat(request.getParameter("total"));
		float tax = Float.parseFloat(request.getParameter("tax"));
		int business_id = Integer.parseInt(request.getParameter("business_id"));
		String date = request.getParameter("date");
		String slip = request.getParameter("slip");
		String id_number = request.getParameter("id_number");
		String payment_method = request.getParameter("payment_method");
		float paid = Float.parseFloat(request.getParameter("paid"));
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
	
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO invoice(business_id,total,tax,products,quantities,date,slip,name,id_number,payment_method) VALUES(?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, business_id);
		ps.setFloat(2, total);
		ps.setFloat(3, tax);
		ps.setString(4, products);
		ps.setString(5, quantities);
		ps.setString(6, date);
		ps.setString(7, slip);
		ps.setString(8, name);
		ps.setString(9, id_number);
		ps.setString(10, payment_method);
		int success=ps.executeUpdate();
		if(success==1) {
		float toReturn= paid-total;
	
	
		request.setAttribute("total", total);
		request.setAttribute("paid", paid);
		request.setAttribute("return", toReturn);
		RequestDispatcher rd = request.getRequestDispatcher("invoiceclosed.jsp");
         rd.forward(request, response);
		}}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}



