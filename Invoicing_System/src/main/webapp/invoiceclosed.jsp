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

    <title>Racuni</title>
  </head>
<body style="background-color:	#aaa7cc">
<div class="container">
<h1>Racun uspesno sacuvan</h1>
Ukupna cena:<%out.println(request.getAttribute("total"));%><br>
Uplaceno:<%out.println(request.getAttribute("paid"));%><br>
Povracaj:<%out.println(request.getAttribute("return"));%><br>
</div>
</body>
</html>