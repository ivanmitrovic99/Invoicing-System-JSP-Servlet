package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/RegisterBusinessByAdmin")
public class RegisterBusinessByAdmin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
			String name = request.getParameter("username");
			String password= request.getParameter("password");
			String confirm_password = request.getParameter("confirm_password");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String person_name = request.getParameter("person_name");
			String business_name = request.getParameter("business_name");
			String pib = request.getParameter("pib");
			String business_number = request.getParameter("business_number");
			String status= "Neaktivan";
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO business(business_name,person_name,username,password,contact_number,business_number,pib,address,email,status) VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, business_name);
			ps.setString(2, person_name);
			ps.setString(3, name);
			ps.setString(4, password);
			ps.setString(5, phone);
			ps.setString(6, business_number);
			ps.setString(7, pib);
			ps.setString(8, address);
			ps.setString(9, email);
			ps.setString(10, status);
			int success=ps.executeUpdate();
			if(success==1) {
			request.setAttribute("Message", "Uspesan unos!");
			response.sendRedirect("AdminServlet");}
			else {
				request.setAttribute("Message", "Greska pri unosu!");
				response.sendRedirect("AdminServlet");
			}

			
			
			  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
