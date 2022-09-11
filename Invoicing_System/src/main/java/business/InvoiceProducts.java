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
@WebServlet("/InvoiceProducts")
public class InvoiceProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		int id= Integer.parseInt(request.getParameter("id"));
		List<Product> list = new ArrayList<Product>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
		
		
		PreparedStatement ps = con.prepareStatement("SELECT products FROM invoice WHERE id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String products= rs.getString(1);
			String[] tokens = products.split(" ");
			int[] arrayProducts = new int[tokens.length];

			int i = 0;
			for (String token : tokens){
			    arrayProducts[i++] = Integer.parseInt(token); 
			}
			for(i=0;i<arrayProducts.length;i++) {
				PreparedStatement ps1 = con.prepareStatement("SELECT p.id,p.name,p.unit,p.tax_rate,p.manufacturer,p.business_id,p.selling_price FROM product p JOIN business b ON p.business_id=b.id WHERE p.id = ?");
				ps1.setInt(1, arrayProducts[i]);
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					Product product = new Product(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getFloat(7),rs1.getInt(6));
					list.add(product);
				
			}
		}}
	
		request.setAttribute("list", list);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("invoiceproducts.jsp");
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



