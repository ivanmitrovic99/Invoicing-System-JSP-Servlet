<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Promena lozinke</title>
  </head>
<body style="background-color:	#aaa7cc">
<div class="container">

<form action=PasswordChangeUser method=post>
 <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>
<br>
    <label for="password"><b>Trenutna sifra</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
<br>
<label for="password"><b>Nova sifra</b></label>
    <input type="password" placeholder="Enter Password" name="new_password" required>
<br>


    <button type="submit">Promeni</button>
    </div>
   
</form>
<%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>
</div>
</body>
</html>