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

    <title>Azuriraj</title>
  </head>
<body style="background-color:	#aaa7cc">

<div class="container" id="addproduct">
<h1>Azuriranje artikla</h1>
<c:set var="object" value="${product}" />
<form action="UpdateProduct?id=${product.id}" method=post>
 <div class="container">
 Opsti podaci<br>
    <label for="name"><b>Naziv</b></label>
    <input type="text" name="name" required value="${product.name}">
<br>
    <label for="unit"><b>Jedinica mere</b></label>
    <input type="text"  name="unit" required value="${product.unit}">
<br>
<label for="tax_rate"><b>Poreska stopa</b></label>
    <input type="text" name="tax_rate" required value="${product.tax_rate}">
<br>
<label for="country"><b>Drzava</b></label>
    <input type="text" name="country" required value="${product.country}">
<br>
Dopunski podaci<br>
<label for="foreign_name"><b>Strano ime</b></label>
    <input type="text" name="foreign_name" value="${product.foreign_name}">
<br>
<label for="barcode"><b>Barkod</b></label>
    <input type="text" name="barcode" value="${product.barcode}">
<br>
<label for="manufacturer"><b>Proizvodjac</b></label>
    <input type="text" name="manufacturer" value="${product.manufacturer}">
<br>
<label for="rate"><b>Carinska tarifa</b></label>
    <input type="text" name="rate" value="${product.rate}">
<br>
<label for="eco_tax"><b>Eko taksa</b></label>
    <input type="text" name="eco_tax" value="${product.eco_tax}">
<br>
<label for="description"><b>Opis</b></label>
    <input type="text" name="description" value="${product.description}">
<br>
<label for="declaration"><b>Deklaracija</b></label>
    <input type="text" name="declaration" value="${product.declaration}">
<br>
Cene i stanje robe<br>
<label for="object_name"><b>Naziv magacina</b></label>
    <input type="text" name="object_name" required value="${product.object_name}">
<br>
<label for="buying_price"><b>Nabavna cena</b></label>
    <input type="text" name="buying_price" required value="${product.buying_price}">
<br>
<label for="selling_price"><b>Prodajna cena</b></label>
    <input type="text" name="selling_price" required value="${product.selling_price}">
<br>
<label for="status"><b>Status</b></label>
    <input type="text" name="status" required value="${product.status}">
<br>
<label for="business_id"><b>Biznis ID</b></label>
    <input type="text" name="business_id" required value="${product.business_id}">
<br>


    <button type="submit">Izmeni</button>
    </div>
   </div>
</form>
</body>
</html>