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
Ukupna cena:<%out.println(request.getAttribute("total"));%><br>
Ukupni porez:<%out.println(request.getAttribute("total_tax"));%><br>

<form action=AddInvoice method=post>

<br>
    <label for="business_id"><b>Biznis ID</b></label>
    <input type="text" name="business_id" required>
<br>
    <label for="total"><b>Ukupna cena</b></label>
    <input type="text"  name="total" required value="<%out.println(request.getAttribute("total"));%>">
<br>
<label for="tax"><b>Ukupan porez</b></label>
    <input type="text" name="tax" required value="<%out.println(request.getAttribute("total_tax"));%>">
<br>
<label for="products"><b>Artikli</b></label>
    <input type="text" name="products" required value="<%out.println(request.getAttribute("products"));%>">
<br>
<label for="quantity"><b>Kolicine</b></label>
    <input type="text" name="quantities" required value="<%out.println(request.getAttribute("quantities"));%>">
<br>
<br>
    <label for="date"><b>Datum</b></label>
    <input type="text" name="date" id="date" required>
<br>
<label for="payment_method">Metod placanja:</label>
<select id="payment_method" name="payment_method">
  <option value="Gotovina">Gotovina</option>
  <option value="Kartica">Kartica</option>
  <option value="Cek">Cek</option>
 
</select>
<br>
    <label for="name"><b>Ime i prezime</b></label>
    <input type="text" name="name">
<br>
<br>
    <label for="slip"><b>Slip</b></label>
    <input type="text" name="slip">
<br>
<br>
    <label for="id_number"><b>Broj licne karte</b></label>
    <input type="text" name="id_number">
<br>
<br>
    <label for="paid"><b>Uplaceno</b></label>
    <input type="text" name="paid">
<br>
<input type="submit" value="Naplati racun">
</form>
<script>
function functionLoad(){
	document.getElementById('date').valueAsDate = new Date();
}</script>
</div>
</body>
</html>