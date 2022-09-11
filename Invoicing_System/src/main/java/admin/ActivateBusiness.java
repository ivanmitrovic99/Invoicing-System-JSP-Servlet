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

import model.Business;

/**
 * Servlet implementation class ActivateBusiness
 */
@WebServlet("/ActivateBusiness")
public class ActivateBusiness extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		
		String id = request.getParameter("id");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
		PreparedStatement ps = con.prepareStatement("SELECT status FROM business WHERE id=?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		if(rs.getString(1).equals("Aktivan")) {
		PreparedStatement ps2 = con.prepareStatement("UPDATE business SET status='Neaktivan' WHERE id=?");
		ps2.setString(1, id);
		ps2.executeUpdate();}
		else {
		PreparedStatement ps1 = con.prepareStatement("UPDATE business SET status='Aktivan' WHERE id=?");
		ps1.setString(1, id);
		ps1.executeUpdate();}
		response.sendRedirect("AdminServlet");
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
