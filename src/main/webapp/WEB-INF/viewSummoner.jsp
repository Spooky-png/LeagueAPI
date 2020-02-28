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
	<div class="background">
		<a href="/">Dashboard</a>
		<div class="container-fluid">
			<div class="summonerInfo">
				<h1>
					<c:out value="${summonerName}" />
				</h1>
				<hr>
				<img class="profileIconBackground"
					style='height: 100px; width: 100px;' src="${profileIcon }"
					alt="${profileIcon }">
				<h3 style="color: #dbba02;">
					Summoner Level:
					<c:out value="${summonerLevel}" />
				</h3>
				<div class="mostpicked">
					<p>Most Played Champs:</p>
					<img style='height: 50px; width: 50px;' src="${champPic }"
						alt="${champPic }">
					<c:choose>
						<c:when test="${championLevel == 4 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/b/b6/Champion_Mastery_Level_4_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041829"
								alt="bloop">| ${masteryPoints }K </c:when>
						<c:when test="${championLevel == 5 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/96/Champion_Mastery_Level_5_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041512"
								alt="bloop">| ${masteryPoints }K </c:when>
						<c:when test="${championLevel == 6 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/b/be/Champion_Mastery_Level_6_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041636"
								alt="bloop">| ${masteryPoints }K </c:when>
						<c:when test="${championLevel == 7 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/7a/Champion_Mastery_Level_7_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041615"
								alt="bloop">| ${masteryPoints }K </c:when>
					</c:choose>
					<img style='height: 50px; width: 50px;' src="${champPic2 }"
						alt="${champPic2 }">
					<c:choose>
						<c:when test="${championLevel2 == 4 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/b/b6/Champion_Mastery_Level_4_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041829"
								alt="bloop">| ${masteryPoints2 }K </c:when>
						<c:when test="${championLevel2 == 5 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/96/Champion_Mastery_Level_5_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041512"
								alt="bloop">| ${masteryPoints2 }K </c:when>
						<c:when test="${championLevel2 == 6 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/b/be/Champion_Mastery_Level_6_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041636"
								alt="bloop">| ${masteryPoints2 }K </c:when>
						<c:when test="${championLevel2 == 7 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/7a/Champion_Mastery_Level_7_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041615"
								alt="bloop">| ${masteryPoints2 }K </c:when>
					</c:choose>
					<img style='height: 50px; width: 50px;' src="${champPic3 }"
						alt="${champPic3}">
					<c:choose>
						<c:when test="${championLevel3 == 4 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/b/b6/Champion_Mastery_Level_4_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041829"
								alt="bloop">| ${masteryPoints3 }K </c:when>
						<c:when test="${championLevel3 == 5 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/96/Champion_Mastery_Level_5_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041512"
								alt="bloop">| ${masteryPoints3 }K </c:when>
						<c:when test="${championLevel3 == 6 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/b/be/Champion_Mastery_Level_6_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041636"
								alt="bloop">| ${masteryPoints3 }K </c:when>
						<c:when test="${championLevel3 == 7 }">
							<img
								src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/7a/Champion_Mastery_Level_7_Flair.png/revision/latest/scale-to-width-down/120?cb=20200113041615"
								alt="bloop">| ${masteryPoints3 }K </c:when>
					</c:choose>
				</div>
			</div>
			<div class="soloQueue">
				<c:choose>
					<c:when test="${tier == null }"> No Solo Queue Info for ${summonerName } </c:when>
					<c:otherwise>
						<h3>Solo Queue</h3>
						<c:choose>
							<c:when test="${tier == 'IRON' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/0/03/Season_2019_-_Iron_1.png/revision/latest/scale-to-width-down/130?cb=20181229234926" />
							</c:when>
							<c:when test="${tier == 'BRONZE' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/f/f4/Season_2019_-_Bronze_1.png/revision/latest/scale-to-width-down/130?cb=20181229234910" />
							</c:when>
							<c:when test="${tier == 'SILVER' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/70/Season_2019_-_Silver_1.png/revision/latest/scale-to-width-down/130?cb=20181229234936" />
							</c:when>
							<c:when test="${tier == 'GOLD' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/96/Season_2019_-_Gold_1.png/revision/latest/scale-to-width-down/130?cb=20181229234920" />
							</c:when>
							<c:when test="${tier == 'PLATINUM' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/74/Season_2019_-_Platinum_1.png/revision/latest/scale-to-width-down/130?cb=20181229234932" />
							</c:when>
							<c:when test="${tier == 'DIAMOND' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/91/Season_2019_-_Diamond_1.png/revision/latest/scale-to-width-down/130?cb=20181229234917" />
							</c:when>
							<c:when test="${tier == 'MASTER' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/1/11/Season_2019_-_Master_1.png/revision/latest/scale-to-width-down/130?cb=20181229234929" />
							</c:when>
							<c:when test="${tier == 'GRANDMASTER' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/76/Season_2019_-_Grandmaster_1.png/revision/latest/scale-to-width-down/130?cb=20181229234923" />
							</c:when>
							<c:when test="${tier == 'CHALLENGER' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5f/Season_2019_-_Challenger_1.png/revision/latest/scale-to-width-down/130?cb=20181229234913" />
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${streak == true }">
								<button class="hotStreak">Hot Streak</button>
							</c:when>
						</c:choose>
						<p>
							<c:out value="${tier }" />
							<c:out value="${division }" />
						</p>
						<p>
							<c:out value="${leaguePoints }" />
							LP
						</p>
						<div class="holdthebar">
							<div class="progress" style="height: 20px;">
								<div class="progress-bar bg-success" role="progressbar"
									style="width:${winPercent}%" aria-valuenow="${totalWins }"
									aria-valuemin="0" aria-valuemax="${totalGames }">${winPercent }%</div>
							</div>
						</div>
						<p>
							Wins:
							<c:out value="${totalWins }" />
						</p>
						<p>
							Losses:
							<c:out value="${totalLosses }" />
						</p>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="flexQueue">
				<c:choose>
					<c:when test="${tier2 == null }">  No Flex Queue Info for ${summonerName }</c:when>
					<c:otherwise>
						<h3>Flex Queue</h3>
						<c:choose>
							<c:when test="${tier2 == 'IRON' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/0/03/Season_2019_-_Iron_1.png/revision/latest/scale-to-width-down/130?cb=20181229234926" />
							</c:when>
							<c:when test="${tier2 == 'BRONZE' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/f/f4/Season_2019_-_Bronze_1.png/revision/latest/scale-to-width-down/130?cb=20181229234910" />
							</c:when>
							<c:when test="${tier2 == 'SILVER' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/70/Season_2019_-_Silver_1.png/revision/latest/scale-to-width-down/130?cb=20181229234936" />
							</c:when>
							<c:when test="${tier2 == 'GOLD' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/96/Season_2019_-_Gold_1.png/revision/latest/scale-to-width-down/130?cb=20181229234920" />
							</c:when>
							<c:when test="${tier2 == 'PLATINUM' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/74/Season_2019_-_Platinum_1.png/revision/latest/scale-to-width-down/130?cb=20181229234932" />
							</c:when>
							<c:when test="${tier2 == 'DIAMOND' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/9/91/Season_2019_-_Diamond_1.png/revision/latest/scale-to-width-down/130?cb=20181229234917" />
							</c:when>
							<c:when test="${tier2 == 'MASTER' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/1/11/Season_2019_-_Master_1.png/revision/latest/scale-to-width-down/130?cb=20181229234929" />
							</c:when>
							<c:when test="${tier2 == 'GRANDMASTER' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/7/76/Season_2019_-_Grandmaster_1.png/revision/latest/scale-to-width-down/130?cb=20181229234923" />
							</c:when>
							<c:when test="${tier2 == 'CHALLENGER' }">
								<img style='height: 80px; width: 80px;'
									src="https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5f/Season_2019_-_Challenger_1.png/revision/latest/scale-to-width-down/130?cb=20181229234913" />
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${streak2 == true }">
								<button class="hotStreak">Hot Streak</button>
							</c:when>
						</c:choose>
						<p>
							<c:out value="${tier2 }" />
							<c:out value="${division2 }" />
						</p>
						<p>
							<c:out value="${leaguePoints2 }" />
							LP
						</p>
						<div class="holdthebar">
							<div class="progress" style="height: 20px;">
								<div class="progress-bar bg-success" role="progressbar"
									style="width:${winPercent2}%" aria-valuenow="${totalWins2 }"
									aria-valuemin="0" aria-valuemax="${totalGames2 }">${winPercent2 }%</div>
							</div>
						</div>
						<p>
							Wins:
							<c:out value="${totalWins2 }" />
						</p>
						<p>
							Losses:
							<c:out value="${totalLosses2 }" />
						</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="currentMatch">
			<c:choose>
				<c:when test="${participant1Name == null}">
					<p>${notingame }</p>
				</c:when>
				<c:otherwise>
					<h5>${matchType }match | Match Start: ${gameStart } | Match
						Length: ${gameMinutes }:${gameSeconds }</h5>
					<table class="table table-hover table-dark table-sm">
						<thead>
							<tr>
								<th scope="col">Blue Team</th>
								<th scope="col">Red Team</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="blueteam"><img
									style='height: 50px; width: 50px;' src="${participant1Champ}"
									alt="${participant1Champ}"><a
									href="/summoner?Name=${participant1Name}">${participant1Name }</a></td>
								<td class="redteam"><img style='height: 50px; width: 50px;'
									src="${participant6Champ}" alt="${participant6Champ}"><a
									href="/summoner?Name=${participant6Name}">${participant6Name }</a></td>
							</tr>
							<tr>
								<td class="blueteam"><img
									style='height: 50px; width: 50px;' src="${participant2Champ}"
									alt="${participant2Champ}"><a
									href="/summoner?Name=${participant2Name}">${participant2Name }</a></td>
								<td class="redteam"><img style='height: 50px; width: 50px;'
									src="${participant7Champ}" alt="${participant7Champ}"><a
									href="/summoner?Name=${participant7Name}">${participant7Name }</a></td>
							</tr>
							<tr>
								<td class="blueteam"><img
									style='height: 50px; width: 50px;' src="${participant3Champ}"
									alt="${participant3Champ}"><a
									href="/summoner?Name=${participant3Name}">${participant3Name }</a></td>
								<td class="redteam"><img style='height: 50px; width: 50px;'
									src="${participant8Champ}" alt="${participant8Champ}"><a
									href="/summoner?Name=${participant8Name}">${participant8Name }</a></td>
							</tr>
							<tr>
								<td class="blueteam"><img
									style='height: 50px; width: 50px;' src="${participant4Champ}"
									alt="${participant4Champ}"><a
									href="/summoner?Name=${participant4Name}">${participant4Name }</a></td>
								<td class="redteam"><img style='height: 50px; width: 50px;'
									src="${participant9Champ}" alt="${participant9Champ}"><a
									href="/summoner?Name=${participant9Name}">${participant9Name }</a></td>
							</tr>
							<tr>
								<td class="blueteam"><img
									style='height: 50px; width: 50px;' src="${participant5Champ}"
									alt="${participant5Champ}"><a
									href="/summoner?Name=${participant5Name}">${participant5Name }</a></td>
								<td class="redteam"><img style='height: 50px; width: 50px;'
									src="${participant10Champ}" alt="${participant10Champ}"><a
									href="/summoner?Name=${participant10Name}">${participant10Name }</a></td>
							</tr>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>