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
 * Servlet implementation class UserServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		List<Business> listBusiness = new ArrayList<Business>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
		PreparedStatement ps = con.prepareStatement("SELECT * FROM business");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Business business = new Business(rs.getInt(1),rs.getString(2),rs.getString(7),rs.getString(3),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(4),rs.getString(5),rs.getString(6));
			listBusiness.add(business);
		}
	
		request.setAttribute("list", listBusiness);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
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



