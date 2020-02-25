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
<link rel="stylesheet" type="text/css" href="/css/viewSummoner.css" />
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
<title>${summonerName }</title>
</head>
<body>
	<h1>
		<c:out value="${summonerName}" />
	</h1>
	<h3>
		Summoner Level: <c:out value="${summonerLevel}" />
	</h3>
	<img src="${profileIcon }" alt="${profileIcon }">
	<p>
		<c:out value="${summonerId }" />
	</p>
	<h3>Solo Queue</h3>
	<c:choose>
	<c:when test="${tier == 'IRON' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/0/03/Season_2019_-_Iron_1.png/revision/latest/scale-to-width-down/130?cb=20181229234926" /></c:when>
		<c:when test="${tier == 'BRONZE' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/f/f4/Season_2019_-_Bronze_1.png/revision/latest/scale-to-width-down/130?cb=20181229234910" /></c:when>
			<c:when test="${tier == 'SILVER' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/70/Season_2019_-_Silver_1.png/revision/latest/scale-to-width-down/130?cb=20181229234936" /></c:when>
			<c:when test="${tier == 'GOLD' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/96/Season_2019_-_Gold_1.png/revision/latest/scale-to-width-down/130?cb=20181229234920" /></c:when>
			<c:when test="${tier == 'PLATINUM' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/74/Season_2019_-_Platinum_1.png/revision/latest/scale-to-width-down/130?cb=20181229234932" /></c:when>
			<c:when test="${tier == 'DIAMOND' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/91/Season_2019_-_Diamond_1.png/revision/latest/scale-to-width-down/130?cb=20181229234917" /></c:when>
			<c:when test="${tier == 'MASTER' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/1/11/Season_2019_-_Master_1.png/revision/latest/scale-to-width-down/130?cb=20181229234929" /></c:when>
			<c:when test="${tier == 'GRANDMASTER' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/76/Season_2019_-_Grandmaster_1.png/revision/latest/scale-to-width-down/130?cb=20181229234923" /></c:when>
			<c:when test="${tier == 'CHALLENGER' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5f/Season_2019_-_Challenger_1.png/revision/latest/scale-to-width-down/130?cb=20181229234913" /></c:when>
			<c:otherwise></c:otherwise></c:choose>
	<c:choose>
		<c:when test="${streak == true }"><button class="hotStreak">Hot Streak</button></c:when>
	</c:choose>
	<p><c:out value="${tier }"/> <c:out value="${division }"/></p>
	<p><c:out value="${leaguePoints }"/> LP</p>
	<div class="holdthebar">
	<div class="progress" style="height: 20px;">
  <div class="progress-bar bg-success" role="progressbar" style="width:${winPercent}%" aria-valuenow="${totalWins }" aria-valuemin="0" aria-valuemax="${totalGames }">${winPercent }%</div>
</div>
</div>
	<p>
		Wins: <c:out value="${totalWins }" />
	</p>
	<p>
		Losses: <c:out value="${totalLosses }" />
	</p>
			<h3>Flex Queue</h3>
	<c:choose>
	<c:when test="${tier2 == 'IRON' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/0/03/Season_2019_-_Iron_1.png/revision/latest/scale-to-width-down/130?cb=20181229234926" /></c:when>
		<c:when test="${tier2 == 'BRONZE' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/f/f4/Season_2019_-_Bronze_1.png/revision/latest/scale-to-width-down/130?cb=20181229234910" /></c:when>
			<c:when test="${tier2 == 'SILVER' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/70/Season_2019_-_Silver_1.png/revision/latest/scale-to-width-down/130?cb=20181229234936" /></c:when>
			<c:when test="${tier2 == 'GOLD' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/96/Season_2019_-_Gold_1.png/revision/latest/scale-to-width-down/130?cb=20181229234920" /></c:when>
			<c:when test="${tier2 == 'PLATINUM' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/74/Season_2019_-_Platinum_1.png/revision/latest/scale-to-width-down/130?cb=20181229234932" /></c:when>
			<c:when test="${tier2 == 'DIAMOND' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/91/Season_2019_-_Diamond_1.png/revision/latest/scale-to-width-down/130?cb=20181229234917" /></c:when>
			<c:when test="${tier2 == 'MASTER' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/1/11/Season_2019_-_Master_1.png/revision/latest/scale-to-width-down/130?cb=20181229234929" /></c:when>
			<c:when test="${tier2 == 'GRANDMASTER' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/76/Season_2019_-_Grandmaster_1.png/revision/latest/scale-to-width-down/130?cb=20181229234923" /></c:when>
			<c:when test="${tier2 == 'CHALLENGER' }">
			<img src="https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5f/Season_2019_-_Challenger_1.png/revision/latest/scale-to-width-down/130?cb=20181229234913" /></c:when>
			<c:otherwise></c:otherwise></c:choose>
	<c:choose>
		<c:when test="${streak2 == true }"><button class="hotStreak">Hot Streak</button></c:when>
	</c:choose>
	<p><c:out value="${tier2 }"/> <c:out value="${division2 }"/></p>
	<p><c:out value="${leaguePoints2 }"/> LP</p>
	<div class="holdthebar">
	<div class="progress" style="height: 20px;">
  <div class="progress-bar bg-success" role="progressbar" style="width:${winPercent2}%" aria-valuenow="${totalWins2 }" aria-valuemin="0" aria-valuemax="${totalGames2 }">${winPercent2 }%</div>
</div>
</div>
			<p>
				Wins: <c:out value="${totalWins2 }" />
			</p>
			<p>
				Losses: <c:out value="${totalLosses2 }" />
			</p>
</body>
</html>