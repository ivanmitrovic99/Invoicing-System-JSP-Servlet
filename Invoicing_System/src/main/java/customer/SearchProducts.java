package customer;

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




@WebServlet("/SearchProducts")
public class SearchProducts extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		List<Product> list = new ArrayList<Product>();
		
		String productName=request.getParameter("name");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
			
				
				PreparedStatement ps1 = con.prepareStatement("SELECT p.name,p.manufacturer,p.selling_price,p.object_name,b.business_name FROM product p JOIN business b ON p.business_id=b.id WHERE p.name = ?;");
				ps1.setString(1, productName);
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					Product product = new Product(rs1.getString(1),rs1.getString(2),rs1.getFloat(3),rs1.getString(4),rs1.getString(5));
					list.add(product);
				}
			
				
				
				request.setAttribute("list", list);
				
				RequestDispatcher rd = request.getRequestDispatcher("searchedproducts.jsp");
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
