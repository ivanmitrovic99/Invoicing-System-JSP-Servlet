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

    <title>Business</title>
  </head>
<body style="background-color:	#aaa7cc;">
<!--  <nav class="navbar navbar-expand-lg navbar-light bg-light"><a href="Products?business=<%out.println(request.getAttribute("id"));%>">Robe i usluge</a>
<a href="ProductsInvoice?business=<%out.println(request.getAttribute("id"));%>">Izdavanje racuna</a>
<a href="Reports?business=<%out.println(request.getAttribute("id"));%>">Pregled izvestaja</a>
<a href="passwordchangeuser.jsp">Promena sifre</a></nav>
<a href="login.jsp">Odjava</a></nav>-->

<nav class="navbar navbar-expand-lg navbar-light bg-light">
 
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="Products?business=<%out.println(request.getAttribute("id"));%>">Robe i usluge <span class="sr-only"></span></a>
      <a class="nav-item nav-link" href="ProductsInvoice?business=<%out.println(request.getAttribute("id"));%>">Izdavanje racuna</a>
      <a class="nav-item nav-link" href="Reports?business=<%out.println(request.getAttribute("id"));%>">Pregled izvestaja</a>
      <a class="nav-item nav-link" href="passwordchangeuser.jsp">Promena sifre</a>
      <a class="nav-item nav-link" href="login.jsp">Odjava</a>
    </div>
  </div>
</nav>



<h1>Preduzece <% if(null!=request.getAttribute("name"))
    {
        out.println(request.getAttribute("name"));
    }
%></h1>
</body>
</html>