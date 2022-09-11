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
@WebServlet("/InvoiceClose")
public class InvoiceClose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		List<Product> list = new ArrayList<Product>();
		String products = request.getParameter("products");
		String[] tokens = products.split(" ");
		int[] arrayProducts = new int[tokens.length];

		int i = 0;
		for (String token : tokens){
		    arrayProducts[i++] = Integer.parseInt(token); 
		}

		String quantities = request.getParameter("quantities");
		String[] tokensQ = quantities.split(" ");
		float[] arrayQuantities = new float[tokensQ.length];

		int j = 0;
		for (String token : tokensQ){
		    arrayQuantities[j++] = Float.parseFloat(token); 
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicing_system","root","");
		float total=0;
		float total_tax=0;
		for(i=0;i<arrayProducts.length;i++) {
		PreparedStatement ps = con.prepareStatement("SELECT p.id,p.name,p.unit,p.tax_rate,p.manufacturer,p.business_id,p.selling_price FROM product p JOIN business b ON p.business_id=b.id WHERE p.id = ?");
		ps.setInt(1, arrayProducts[i]);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(7),rs.getInt(6));
			list.add(product);
			float tax=Float.parseFloat(rs.getString(4));
			total=total+rs.getFloat(7)*arrayQuantities[i];
			if(tax!=0) {
				total_tax=total_tax+rs.getFloat(7)*arrayQuantities[i]*(tax/100);
			}
			
			
		}}
	
		request.setAttribute("list", list);
		request.setAttribute("total", total);
		request.setAttribute("total_tax", total_tax);
		request.setAttribute("products", products);
		request.setAttribute("quantities", quantities);
		RequestDispatcher rd = request.getRequestDispatcher("invoiceclose.jsp");
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



