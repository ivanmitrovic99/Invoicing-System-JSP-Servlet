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

    <title>Admin</title>
  </head>
<body style="background-color:	#aaa7cc;">
<br>

<div class="container p-3 d-flex justify-content-center">
<h1>Izvestaj za preduzece:<%out.println(request.getAttribute("name"));%></h1><br>
<br>Ukupno:<%out.println(request.getAttribute("total"));%><br>
Ukupan porez:<%out.println(request.getAttribute("tax"));%><br>
</div>
</body>
</html>