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




@WebServlet("/RegisterCustomerByAdmin")
public class RegisterCustomerByAdmin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
			String id = request.getParameter("id");
			String name = request.getParameter("username");
			String password= request.getParameter("password");
			String phone = request.getParameter("phone");
			String id_number = request.getParameter("id_number");
			String person_name = request.getParameter("person_name");
			PreparedStatement ps = con.prepareStatement("INSERT INTO customer(id,username,password,name,id_number,number) VALUES(?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setString(4, person_name);
			ps.setString(5, id_number);
			ps.setString(6, phone);
			
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
