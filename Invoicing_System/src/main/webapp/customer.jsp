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

    <title>Kupac</title>
  </head>
<body style="background-color:	#aaa7cc">
<div class="container">
<form action="SearchProducts" method="post" class="form-group">
<h3>Pretraga:</h3>
<input type="text" name="name">
<input type="submit">
</form>
<c:forEach items="${listBusiness}" var="business">
<c:out value="${business.business_name}" />
<table id="table" class="table table-bordered table-primary table-striped table-hover">
  <th> Ime</th>
  <th> Proizvodjac</th>
  <th> Objekat</th>
  <th> Cena</th>
  
  <c:forEach items="${list}" var="product">
  <c:if test="${product.business_id==business.id}">
    <tr>
      <td><c:out value="${product.name}" /></td>
       <td><c:out value="${product.manufacturer}" /></td>
       <td><c:out value="${product.object_name}" /></td>
       <td><c:out value="${product.selling_price}" /></td>
    </tr>
    </c:if>
  </c:forEach>
</table>
</c:forEach>
</div>
</body>
</html>