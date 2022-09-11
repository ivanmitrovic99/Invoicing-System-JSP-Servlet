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

    <title>Admin</title>
  </head>
<body style="background-color:	#aaa7cc">
<div class="container">
<h3>Lista zahteva za registraciju</h3>
<a href="passwordchange.jsp">Promena lozinke</a>
<table id="table" class="table table-bordered table-primary table-striped table-hover">
<th>Ime biznisa</th>
  <th> Maticni broj</th>
  <th> Odgovorno lice</th>
  <th> Adresa</th>
  <th> Status</th>
  <c:forEach items="${list}" var="business">
  
    <tr>
      <td><c:out value="${business.business_name}" /></td>
       <td><c:out value="${business.business_number}" /></td>
       <td><c:out value="${business.person_name}" /></td>
       <td><c:out value="${business.address}" /></td>
       <td><c:out value="${business.status}" /></td>
       <td><a href="ActivateBusiness?id=${business.id}">Aktiviraj/Deaktiviraj</a></td>
       
    
    </tr>
  </c:forEach>
</table>

<h1>Registracija preduzeca</h1>
<form action=RegisterBusinessByAdmin method=post class="form-group">
 
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
 
   
</form>
<h1>Registracija kupca</h1>
<form action=RegisterCustomerByAdmin method=post class="form-group">
 
 <label for="id"><b>Id</b></label>
    <input type="text" name="id" required>
<br>
    <label for="username"><b>Username</b></label>
    <input type="text" name="username" required>
<br>
    <label for="password"><b>Password</b></label>
    <input type="password"  name="password" required>
<br>
<label for="person_name"><b>Ime</b></label>
    <input type="text" name="person_name" required>
<br>
<label for="id_number"><b>Broj licne karte</b></label>
    <input type="text" name="id_number" required>
<br>
<label for="phone"><b>Telefon</b></label>
    <input type="text" name="phone" required>
<br>


    <button type="submit">Register</button>
   
   
</form>


<h1>Izvestaj o preduzecu:</h1>
<form action="AdminReport" method="post" class="form-group">
<label for="pib"><b>PIB</b></label>
    <input type="text" name="pib" required>
<br>
<label for="date_start"><b>OD</b></label>
    <input type="text" name="date_start" required>
<br>
<label for="date_end"><b>DO</b></label>
    <input type="text" name="date_end" required>
<br>
<button type="submit">Pogledaj</button>
</form>


<h2><%
    if(null!=request.getAttribute("Message"))
    {
        out.println(request.getAttribute("Message"));
    }
%></h2>
</div>
</body>
</html>