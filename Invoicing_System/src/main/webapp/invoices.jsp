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

    <title>Izvestaji</title>
  </head>
<body style="background-color:	#aaa7cc">
<div class="container">
<form action="MoneyReport" method="post">
Unesi datum:
<input type="text" name="date">
<input type="submit" value="Pogledaj">
</form>
<table id="table" class="table table-bordered table-primary table-striped table-hover">
<th>Sifra racuna</th>
  <th> Metod placanja</th>
  <th> Ime</th>
  <th> Ukupno</th>
  <th> Porez</th>
  <c:forEach items="${list}" var="invoice">
  
    <tr>
      <td><c:out value="${invoice.id}" /></td>
       <td><c:out value="${invoice.payment_method}" /></td>
       <td><c:out value="${invoice.name}" /></td>
       <td><c:out value="${invoice.total}" /></td>
       <td><c:out value="${invoice.tax}" /></td>
       <td><a href="InvoiceProducts?id=${invoice.id}">Pogledaj stavke</a></td>
       
       
    
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>
<