<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${name}</title>
</head>
<body>
<h1><c:out value="${name}"/> the <c:out value="${title}"/></h1>
<p>Lore: <c:out value="${lore}"/></p>
<p><c:out value="${spellQName }"/></p>
<p><c:out value="${spellQDescription }"/></p>
</body>
</html>