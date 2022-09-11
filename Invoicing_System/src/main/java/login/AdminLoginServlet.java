package login;

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


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
			String name = request.getParameter("username");
			String password= request.getParameter("password");
			
			/*System.out.print(name);
			System.out.print(password);
			System.out.print(role);*/
			PreparedStatement ps = con.prepareStatement("SELECT * FROM administrator WHERE username=? AND password=?");
			ps.setString(1, name);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			
			  
			if(rs.next()) {
				//System.out.print(rs.getString(4));
				//System.out.print(rs.getString(4)==role.toLowerCase());
				
				response.sendRedirect("AdminServlet");}
				
				else
				{request.setAttribute("errorMessage", "Pogresno uneti username ili password!");
				RequestDispatcher rd = request.getRequestDispatcher("adminlogin.jsp");
	             rd.forward(request, response); }
			  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
