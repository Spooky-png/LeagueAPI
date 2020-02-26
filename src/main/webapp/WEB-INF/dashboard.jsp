<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<h1>Super cool League app</h1>
<form id="championSearch" action="/champion{Name}">
<input type="text" name="Name" placeholder="Search a champion"><button type="submit">Search</button>
</form>
<form id="summonerSearch" action="/summoner{Name}">
<input type="text" name="Name" placeholder="Search a summoner"><button type="submit">Search</button>
</form>
</body>
</html>