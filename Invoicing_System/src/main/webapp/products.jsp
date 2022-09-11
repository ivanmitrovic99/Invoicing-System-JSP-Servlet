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

    <title>Artikli</title>
  </head>
<body style="background-color:	#aaa7cc">
<div class="container">
<table id="table" class="table table-bordered table-primary table-striped table-hover">
<th>Sifra artikla</th>
  <th> Ime</th>
  <th> Jedinica mere</th>
  <th> Poreska stopa</th>
  <th> Proizvodjac</th>
  <c:forEach items="${list}" var="product">
  
    <tr>
      <td><c:out value="${product.id}" /></td>
       <td><c:out value="${product.name}" /></td>
       <td><c:out value="${product.unit}" /></td>
       <td><c:out value="${product.tax_rate}" /></td>
       <td><c:out value="${product.manufacturer}" /></td>
       <td><a href="UpdatePage?id=${product.id}">Izmeni</a></td>
       <td><a href="DeleteProduct?id=${product.id}&business=${product.business_id}" onclick="if (confirm('Obrisi artikal?')){return true;}else{event.stopPropagation(); event.preventDefault();};" title="Link Title">Izbrisi</a></td>
       
    
    </tr>
  </c:forEach>
</table>
<button onclick="Function()">UNOS</button>
<div class="container" id="addproduct" style="display:none">
<h1>Dodavanje artikla</h1>
<form action=AddProduct method=post>
 <div class="container">
 Opsti podaci<br>
    <label for="name"><b>Naziv</b></label>
    <input type="text" name="name" required>
<br>
    <label for="unit"><b>Jedinica mere</b></label>
    <input type="text"  name="unit" required>
<br>
<label for="tax_rate"><b>Poreska stopa</b></label>
    <input type="text" name="tax_rate" required>
<br>
<label for="country"><b>Drzava</b></label>
    <input type="text" name="country" required>
<br>
Dopunski podaci<br>
<label for="foreign_name"><b>Strano ime</b></label>
    <input type="text" name="foreign_name" >
<br>
<label for="barcode"><b>Barkod</b></label>
    <input type="text" name="barcode" >
<br>
<label for="manufacturer"><b>Proizvodjac</b></label>
    <input type="text" name="manufacturer" >
<br>
<label for="rate"><b>Carinska tarifa</b></label>
    <input type="text" name="rate" >
<br>
<label for="eco_tax"><b>Eko taksa</b></label>
    <input type="text" name="eco_tax">
<br>
<label for="description"><b>Opis</b></label>
    <input type="text" name="description" >
<br>
<label for="declaration"><b>Deklaracija</b></label>
    <input type="text" name="declaration" >
<br>
Cene i stanje robe<br>
<label for="object_name"><b>Naziv magacina</b></label>
    <input type="text" name="object_name" required>
<br>
<label for="buying_price"><b>Nabavna cena</b></label>
    <input type="text" name="buying_price" required>
<br>
<label for="selling_price"><b>Prodajna cena</b></label>
    <input type="text" name="selling_price" required>
<br>
<label for="status"><b>Status</b></label>
    <input type="text" name="status" required>
<br>
<label for="business_id"><b>Biznis ID</b></label>
    <input type="text" name="business_id" required>
<br>


    <button type="submit">Dodaj</button>
    </div>
   </div>
</form>
<script>
function Function(){
	document.getElementById("addproduct").style.display = "block";
}
</script>
</div>
</body>
</html>