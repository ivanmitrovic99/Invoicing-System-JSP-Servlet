package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Invoice;




@WebServlet("/Home")
public class Home extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		ArrayList<Invoice> list = new ArrayList<Invoice>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
			PreparedStatement ps = con.prepareStatement("SELECT i.total,i.tax,i.date,b.business_name,i.products FROM Invoice i JOIN business b ON i.business_id=b.id ORDER BY i.id DESC LIMIT 5");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Invoice invoice = new Invoice(rs.getFloat(1),rs.getFloat(2),rs.getString(5),rs.getString(4),rs.getString(3));
				list.add(invoice);
			}
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
             rd.forward(request, response);
			
			
			
			  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
