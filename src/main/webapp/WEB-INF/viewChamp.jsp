<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/viewChamp.css" />
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>${name}</title>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<div id="carouselCaptions" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselCaption1" data-slide-to="0" class="active"></li>
			<li data-target="#carouselCaption2" data-slide-to="1"></li>
			<li data-target="#carouselCaption3" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active" data-interval="10000">
				<img style='height: 100%; width: 100%; object-fit: contain'
					src="${champSplash}" class="d-block w-100" alt="${champSplash}">
				<div class="carousel-caption d-none d-md-block">
					<h5>${name}</h5>
					<p>${tip1}</p>
				</div>
			</div>
			<div class="carousel-item" data-interval="10000">
				<img style='height: 100%; width: 100%; object-fit: contain'
					src="${champSplash1}" class="d-block w-100" alt="${champSplash1}">
				<div class="carousel-caption d-none d-md-block">
					<h5>${skins2}</h5>
					<p>${tip2 }</p>
				</div>
			</div>
			<div class="carousel-item" data-interval="10000">
				<c:choose>
					<c:when test="${champSplash2 == null }">
						<img style='height: 100%; width: 100%; object-fit: contain'
							src="${champSplash}" class="d-block w-100" alt="${champSplash}">
					</c:when>
					<c:otherwise><img
							style='height: 100%; width: 100%; object-fit: contain'
							src="${champSplash2}" class="d-block w-100" alt="${champSplash2}"></c:otherwise>
				</c:choose>
				<div class="carousel-caption d-none d-md-block">
					<h5>${skins3}</h5>
					<p>${tip3 }</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselCaptions"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselCaptions"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<nav
		class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top container-fluid">
		<ul class="navbar-nav">
			<li class="nav-item"><a href="#content1" class="nav-link active">Lore</a></li>
			<li class="nav-item"><a href="#content2" class="nav-link active"><c:out
						value="${passiveName }" /></a></li>
			<li class="nav-item"><a href="#content3" class="nav-link active"><c:out
						value="${spellQName }" /></a></li>
			<li class="nav-item"><a href="#content4" class="nav-link active"><c:out
						value="${spellWName }" /></a></li>
			<li class="nav-item"><a href="#content5" class="nav-link active"><c:out
						value="${spellEName }" /></a></li>
			<li class="nav-item"><a href="#content6" class="nav-link active"><c:out
						value="${spellRName }" /></a></li>
		</ul>
	</nav>
	<div id="content1" class="container-fluid bg-secondary"
		style="padding-top: 20px; padding-bottom: 20px;">
		<h1>Lore</h1>
		<p>
			<c:out value="${lore}" />
		</p>
	</div>
	<div id="content2" class="container-fluid bg-dark"
		style="padding-top: 20px; padding-bottom: 20px;">
		<h1>
			<img src="${passiveImagePic}" alt="${passiveImagePic}" />
			<c:out value="${passiveName }" />
		</h1>
		<p>
			<c:out value="${passiveDescription }" />
		</p>
	</div>
	<div id="content3" class="container-fluid bg-secondary"
		style="padding-top: 20px; padding-bottom: 20px;">
		<h1>
			<img src="${spellQImagePic}" alt="${spellQImagePic}" />
			<c:out value="${spellQName }" />
		</h1>
		<p>
			<c:out value="${spellQDescription }" />
		</p>
	</div>
	<div id="content4" class="container-fluid bg-dark"
		style="padding-top: 20px; padding-bottom: 20px;">
		<h1>
			<img src="${spellWImagePic}" alt="${spellWImagePic}" />
			<c:out value="${spellWName }" />
		</h1>
		<p>
			<c:out value="${spellWDescription }" />
		</p>
	</div>
	<div id="content5" class="container-fluid bg-secondary"
		style="padding-top: 20px; padding-bottom: 20px;">
		<h1>
			<img src="${spellEImagePic}" alt="${spellEImagePic}" />
			<c:out value="${spellEName }" />
		</h1>
		<p>
			<c:out value="${spellEDescription }" />
		</p>
	</div>
	<div id="content6" class="container-fluid bg-dark"
		style="padding-top: 20px; padding-bottom: 20px;">
		<h1>
			<img src="${spellRImagePic}" alt="${spellRImagePic}" />
			<c:out value="${spellRName }" />
		</h1>
		<p>
			<c:out value="${spellRDescription }" />
		</p>
	</div>
</body>
</html>
