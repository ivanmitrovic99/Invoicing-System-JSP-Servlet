<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Racuni</title>
  </head>
<body style="background-color:	#aaa7cc">
<div class="container">
<table id="table" class="table table-bordered table-primary table-striped table-hover">
<th>Sifra artikla</th>
  <th> Ime</th>
  <th> Jedinica mere</th>
  <th> Poreska stopa</th>
  <th> Proizvodjac</th>
  <th> Cena artikla</th>
  <th> </th>
  <c:forEach items="${list}" var="product">
  
    <tr>
      <td><c:out value="${product.id}" /></td>
       <td><c:out value="${product.name}" /></td>
       <td><c:out value="${product.unit}" /></td>
       <td><c:out value="${product.tax_rate}" /></td>
       <td><c:out value="${product.manufacturer}" /></td>
       <td><c:out value="${product.selling_price}" /></td>
       <td><button onclick="add(<c:out value="${product.id}" /> )">Dodaj</button><td>
    
    </tr>
  </c:forEach>
</table>
Kolicina
<input type="text" id="quantity"><br>
<form action=InvoiceClose method=post>
<input type="text" id="products" name="products" hidden><br>
<input type="text" id="quantities" name="quantities" hidden><br>
<input type="submit" value="Zatvori racun">
</form>
<script>
function add(product){
	
	
	
	var quantity= document.getElementById("quantity").value;
	//document.getElementById("products").value+=product;
	document.getElementById("products").value+=product + ' ';
	document.getElementById("quantities").value+=quantity + ' ';
}</script>
</div>
</body>
</html>