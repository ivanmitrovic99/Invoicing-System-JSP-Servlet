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

    <title>Pretraga</title>
  </head>
<body style="background-color:	#aaa7cc">
<div class="container">



<table id="table" class="table table-bordered table-primary table-striped table-hover">
  <th> Ime</th>
  <th> Proizvodjac</th>
  <th> Objekat</th>
  <th> Cena</th>
  <th> Preduzece</th>
  
  <c:forEach items="${list}" var="product">
  
    <tr>
      <td><c:out value="${product.name}" /></td>
       <td><c:out value="${product.manufacturer}" /></td>
       <td><c:out value="${product.object_name}" /></td>
       <td><c:out value="${product.selling_price}" /></td>
       <td><c:out value="${product.description}" /></td>
    </tr>

  </c:forEach>
</table>
<button onclick="history.back()">Nazad</button>
</div>
</body>
</html>