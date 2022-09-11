package business;

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




@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
			String name = request.getParameter("name");
			String unit= request.getParameter("unit");
			String tax_rate = request.getParameter("tax_rate");
			String country = request.getParameter("country");
			String foreign_name = request.getParameter("foreign_name");
			String barcode = request.getParameter("barcode");
			String manufacturer = request.getParameter("manufacturer");
			String rate = request.getParameter("rate");
			String eco_tax = request.getParameter("eco_tax");
			String description = request.getParameter("description");
			String declaration = request.getParameter("declaration");
			String object_name = request.getParameter("object_name");
			float buying_price =Float.parseFloat(request.getParameter("buying_price"));
			float selling_price =Float.parseFloat(request.getParameter("selling_price"));
			String status = request.getParameter("status");
			String  business_id= request.getParameter("business_id");
			PreparedStatement ps = con.prepareStatement("INSERT INTO product ( name, unit, tax_rate, country, foreign_name, barcode, manufacturer, rate, eco_tax, description, declaration, object_name, buying_price, selling_price, status, business_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, unit);
			ps.setString(3, tax_rate);
			ps.setString(4, country);
			ps.setString(5, foreign_name);
			ps.setString(6, barcode);
			ps.setString(7, manufacturer);
			ps.setString(8, rate);
			ps.setString(9, eco_tax);
			ps.setString(10, description);
			ps.setString(11, declaration);
			ps.setString(12, object_name);
			ps.setFloat(13, buying_price);
			ps.setFloat(14, selling_price);
			ps.setString(15, status);
			ps.setString(16, business_id);
			int success=ps.executeUpdate();
			if(success==1) {
				response.sendRedirect("Products?business="+business_id);
				
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
