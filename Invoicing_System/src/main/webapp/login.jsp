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

    <title>Login</title>
  </head>
<body style="background-color:	#aaa7cc">
<div class="container">
<h1>Ulogujte se na sistem kao preduzece</h1>
<form action=LoginServlet method=post>
 <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>
<br>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
<br>

    <button type="submit" onclick="login()">Login</button>
    </div>
   
</form>
<%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>
<h1>Ulogujte se na sistem kao kupac</h1>
<form action=LoginServletCustomer method=post>
 <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>
<br>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
<br>

    <button type="submit">Login</button>
    </div>
   
</form>
<h1>Registracija preduzeca</h1>
<form action=RegisterServlet method=post>
 <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" name="username" required>
<br>
    <label for="password"><b>Password</b></label>
    <input type="password"  name="password" required>
<br>
<label for="confirm_password"><b>Potvrdi password</b></label>
    <input type="password" name="confirm_password" required>
<br>
<label for="person_name"><b>Ime i prezime odgovornog lica</b></label>
    <input type="text" name="person_name" required>
<br>
<label for="phone"><b>Telefon</b></label>
    <input type="text" name="phone" required>
<br>
<label for="email"><b>Email</b></label>
    <input type="text" name="email" required>
<br>
<label for="business_name"><b>Naziv preduzeca</b></label>
    <input type="text" name="business_name" required>
<br>
<label for="address"><b>Address</b></label>
    <input type="text" name="address" required>
<br>
<label for="pib"><b>PIB</b></label>
    <input type="text" name="pib" required>
<br>
<label for="phone"><b>Maticni broj</b></label>
    <input type="text" name="business_number" required>
<br>

    <button type="submit">Register</button>
    </div>
   
</form>
<h2><%
    if(null!=request.getAttribute("Message"))
    {
        out.println(request.getAttribute("Message"));
    }
%></h2>
<h1>Poslednjih 5 racuna</h1>
<table id="table" class="table table-bordered table-primary table-striped table-hover">
<th>Preduzece</th>
  <th> Ukupno</th>
  <th> Porez</th>
  <th> Datum</th>
  <th> Stavke(ID)</th>
  <c:forEach items="${list}" var="invoice">
  
    <tr>
      <td><c:out value="${invoice.name}" /></td>
       <td><c:out value="${invoice.total}" /></td>
       <td><c:out value="${invoice.tax}" /></td>
       <td><c:out value="${invoice.date}" /></td>
       <td><c:out value="${invoice.products}" /></td>
    </tr>
  </c:forEach>
</table>


</div>
</body>
</html>