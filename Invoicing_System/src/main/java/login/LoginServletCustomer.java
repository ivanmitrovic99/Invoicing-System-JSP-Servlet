package login;

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
import model.Product;




@WebServlet("/LoginServletCustomer")
public class LoginServletCustomer extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		List<Product> list = new ArrayList<Product>();
		List<Business> list2 = new ArrayList<Business>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
			String name = request.getParameter("username");
			String password= request.getParameter("password");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE username=? AND password=?");
			ps.setString(1, name);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			
			  
			if(rs.next()) {
				//System.out.print(rs.getString(4));
				//System.out.print(rs.getString(4)==role.toLowerCase());
				
				PreparedStatement ps1 = con.prepareStatement("SELECT name,manufacturer,selling_price,object_name,business_id FROM product;");
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					Product product = new Product(rs1.getString(1),rs1.getString(2),rs1.getFloat(3),rs1.getString(4),rs1.getInt(5));
					list.add(product);
				}
				PreparedStatement ps2 = con.prepareStatement("SELECT business_name,id FROM business;");
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()) {
					Business business= new Business(rs2.getInt(2),rs2.getString(1));
					list2.add(business);
				}
				
				request.setAttribute("list", list);
				request.setAttribute("listBusiness", list2);
				RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
	             rd.forward(request, response); }
				
				else
				{request.setAttribute("errorMessage", "Pogresno uneti username ili password!");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
