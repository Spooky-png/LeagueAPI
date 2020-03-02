package com.spooky.league.controllers;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.spooky.league.services.LeagueService;

@Controller
public class LeagueController {
	private final LeagueService leagueService;

	public LeagueController(LeagueService leagueService) {
		this.leagueService = leagueService;
	}

	@RequestMapping("/")
	public String dashboard(Model model) throws Exception {
		return "dashboard.jsp";
	}

	@RequestMapping("/summoner{Name}")
	public String getSummoner(@RequestParam("Name") String Name, Model model) throws Exception {
		try {
			String url = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
			String Origin = "https://developer.riotgames.com";
			String token = "KEEEEEY";
			String language = "en-US,en;q=0.9";
			String s = Name;

			HttpResponse<JsonNode> response = Unirest.get(url + s).header("Origin", Origin)
					.header("X-Riot-Token", token).header("Accept-Language", language).asJson();
			JSONObject myObj = response.getBody().getObject();
			String name = myObj.getString("name");
			String summonerId = myObj.getString("id");
			Long level = myObj.getLong("summonerLevel");
			int profileIcon = myObj.getInt("profileIconId");
			model.addAttribute("summonerId", summonerId);
			model.addAttribute("profileIcon",
					"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/profileicon/" + profileIcon + ".png");
			model.addAttribute("summonerName", name);
			model.addAttribute("summonerLevel", level);

			String url2 = "https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId;
			HttpResponse<JsonNode> response2 = Unirest.get(url2).header("Origin", Origin).header("X-Riot-Token", token)
					.header("Accept-Language", language).asJson();
			JSONArray myObj2 = response2.getBody().getArray();
			try {
				JSONObject soloQueue = myObj2.getJSONObject(0);
				String tier = soloQueue.getString("tier");
				boolean streak = soloQueue.getBoolean("hotStreak");
				int totalWins = soloQueue.getInt("wins");
				int totalLosses = soloQueue.getInt("losses");
				String division = soloQueue.getString("rank");
				int leaguePoints = soloQueue.getInt("leaguePoints");
				int totalGames = totalWins + totalLosses;
				float winPercent = (float) totalWins / totalGames * 100;
				model.addAttribute("winPercent", winPercent);
				model.addAttribute("tier", tier);
				model.addAttribute("streak", streak);
				model.addAttribute("totalWins", totalWins);
				model.addAttribute("totalLosses", totalLosses);
				model.addAttribute("division", division);
				model.addAttribute("leaguePoints", leaguePoints);
				model.addAttribute("totalGames", totalGames);
			} catch (Exception e) {
				System.out.println("No Solo Queue info");
			}
			try {
				JSONObject flexQueue = myObj2.getJSONObject(1);
				String tier2 = flexQueue.getString("tier");
				boolean streak2 = flexQueue.getBoolean("hotStreak");
				int totalWins2 = flexQueue.getInt("wins");
				int totalLosses2 = flexQueue.getInt("losses");
				String division2 = flexQueue.getString("rank");
				int leaguePoints2 = flexQueue.getInt("leaguePoints");
				int totalGames2 = totalWins2 + totalLosses2;
				float winPercent2 = (float) totalWins2 / totalGames2 * 100;
				model.addAttribute("winPercent2", winPercent2);
				model.addAttribute("tier2", tier2);
				model.addAttribute("streak2", streak2);
				model.addAttribute("totalWins2", totalWins2);
				model.addAttribute("totalLosses2", totalLosses2);
				model.addAttribute("division2", division2);
				model.addAttribute("leaguePoints2", leaguePoints2);
				model.addAttribute("totalGames2", totalGames2);
			} catch (Exception b) {
				System.out.println("No Flex Queue info");
			}
			try {
				String url3 = "https://na1.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/" + summonerId;
				HttpResponse<JsonNode> response3 = Unirest.get(url3).header("Origin", Origin)
						.header("X-Riot-Token", token).header("Accept-Language", language).asJson();
				JSONObject participantsObj = response3.getBody().getObject();
				String matchType = participantsObj.getString("gameMode");
				model.addAttribute("matchType", matchType);
				Long gameStart = participantsObj.getLong("gameStartTime");
				long epoch = System.currentTimeMillis()/1000;
				long gameLengthEpoch = epoch - gameStart/1000;
				long gameMinutes = (long) Math.floor(gameLengthEpoch/60);
				long gameSeconds = (long) Math.floor(gameLengthEpoch%60);
				String date = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date(gameStart));
				model.addAttribute("gameStart", date);
				model.addAttribute("gameMinutes", gameMinutes);
				model.addAttribute("gameSeconds", gameSeconds);
				JSONArray participants = participantsObj.getJSONArray("participants");
				JSONObject participant1 = participants.getJSONObject(0);
				Long participant1Champ = participant1.getLong("championId");
				String participant1Name = participant1.getString("summonerName");
				String participant1Id = participant1.getString("summonerId");
				model.addAttribute("participant1Name", participant1Name);
				model.addAttribute("participant1Id", participant1Id);
				JSONObject participant2 = participants.getJSONObject(1);
				Long participant2Champ = participant2.getLong("championId");
				String participant2Name = participant2.getString("summonerName");
				String participant2Id = participant2.getString("summonerId");
				model.addAttribute("participant2Name", participant2Name);
				model.addAttribute("participant2Id", participant2Id);
				JSONObject participant3 = participants.getJSONObject(2);
				Long participant3Champ = participant3.getLong("championId");
				String participant3Name = participant3.getString("summonerName");
				String participant3Id = participant3.getString("summonerId");
				model.addAttribute("participant3Name", participant3Name);
				model.addAttribute("participant3Id", participant3Id);
				JSONObject participant4 = participants.getJSONObject(3);
				Long participant4Champ = participant4.getLong("championId");
				String participant4Name = participant4.getString("summonerName");
				String participant4Id = participant4.getString("summonerId");
				model.addAttribute("participant4Name", participant4Name);
				model.addAttribute("participant4Id", participant4Id);
				JSONObject participant5 = participants.getJSONObject(4);
				Long participant5Champ = participant5.getLong("championId");
				String participant5Name = participant5.getString("summonerName");
				String participant5Id = participant5.getString("summonerId");
				model.addAttribute("participant5Name", participant5Name);
				model.addAttribute("participant5Id", participant5Id);
				JSONObject participant6 = participants.getJSONObject(5);
				Long participant6Champ = participant6.getLong("championId");
				String participant6Name = participant6.getString("summonerName");
				String participant6Id = participant6.getString("summonerId");
				model.addAttribute("participant6Name", participant6Name);
				model.addAttribute("participant6Id", participant6Id);
				JSONObject participant7 = participants.getJSONObject(6);
				Long participant7Champ = participant7.getLong("championId");
				String participant7Name = participant7.getString("summonerName");
				String participant7Id = participant7.getString("summonerId");
				model.addAttribute("participant7Name", participant7Name);
				model.addAttribute("participant7Id", participant7Id);
				JSONObject participant8 = participants.getJSONObject(7);
				Long participant8Champ = participant8.getLong("championId");
				String participant8Name = participant8.getString("summonerName");
				String participant8Id = participant8.getString("summonerId");
				model.addAttribute("participant8Name", participant8Name);
				model.addAttribute("participant8Id", participant8Id);
				JSONObject participant9 = participants.getJSONObject(8);
				Long participant9Champ = participant9.getLong("championId");
				String participant9Name = participant9.getString("summonerName");
				String participant9Id = participant9.getString("summonerId");
				model.addAttribute("participant9Name", participant9Name);
				model.addAttribute("participant9Id", participant9Id);
				JSONObject participant10 = participants.getJSONObject(9);
				Long participant10Champ = participant10.getLong("championId");
				String participant10Name = participant10.getString("summonerName");
				String participant10Id = participant10.getString("summonerId");
				model.addAttribute("participant10Name", participant10Name);
				model.addAttribute("participant10Id", participant10Id);
				String url6 = "http://ddragon.leagueoflegends.com/cdn/10.4.1/data/en_US/champion.json";
				HttpResponse<JsonNode> response6 = Unirest.get(url6).asJson();
				JSONObject gameChampsObj = response6.getBody().getObject();
				JSONObject dataObj = gameChampsObj.getJSONObject("data");
				Iterator<String> keys = dataObj.keys();
				while (keys.hasNext()) {
					String keyVal = keys.next();
					JSONObject champObj = dataObj.getJSONObject((String) keyVal);
					if (champObj.getLong("key") == participant1Champ) {
						String champName = keyVal;
						model.addAttribute("participant1Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant2Champ) {
						String champName = keyVal;
						model.addAttribute("participant2Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant3Champ) {
						String champName = keyVal;
						model.addAttribute("participant3Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant4Champ) {
						String champName = keyVal;
						model.addAttribute("participant4Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant5Champ) {
						String champName = keyVal;
						model.addAttribute("participant5Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant6Champ) {
						String champName = keyVal;
						model.addAttribute("participant6Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant7Champ) {
						String champName = keyVal;
						model.addAttribute("participant7Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant8Champ) {
						String champName = keyVal;
						model.addAttribute("participant8Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant9Champ) {
						String champName = keyVal;
						model.addAttribute("participant9Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant10Champ) {
						String champName = keyVal;
						model.addAttribute("participant10Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
				}
			} catch (Exception n) {
				System.out.println("Not in game");
				model.addAttribute("notingame", "Summoner not currently in a game.");
			}
			String url4 = "https://na1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
					+ summonerId;
			HttpResponse<JsonNode> response4 = Unirest.get(url4).header("Origin", Origin).header("X-Riot-Token", token)
					.header("Accept-Language", language).asJson();
			JSONArray getChampIdObj = response4.getBody().getArray();
			JSONObject favoriteChampId = getChampIdObj.getJSONObject(0);
			Long champId = favoriteChampId.getLong("championId");
			int masteryPoints = favoriteChampId.getInt("championPoints");
			int championLevel = favoriteChampId.getInt("championLevel");
			model.addAttribute("masteryPoints", masteryPoints);
			model.addAttribute("championLevel", championLevel);
			JSONObject favoriteChampId2 = getChampIdObj.getJSONObject(1);
			Long champId2 = favoriteChampId2.getLong("championId");
			int masteryPoints2 = favoriteChampId2.getInt("championPoints");
			int championLevel2 = favoriteChampId2.getInt("championLevel");
			model.addAttribute("masteryPoints2", masteryPoints2);
			model.addAttribute("championLevel2", championLevel2);
			JSONObject favoriteChampId3 = getChampIdObj.getJSONObject(2);
			Long champId3 = favoriteChampId3.getLong("championId");
			int masteryPoints3 = favoriteChampId3.getInt("championPoints");
			int championLevel3 = favoriteChampId3.getInt("championLevel");
			model.addAttribute("masteryPoints3", masteryPoints3);
			model.addAttribute("championLevel3", championLevel3);

			String url5 = "http://ddragon.leagueoflegends.com/cdn/10.4.1/data/en_US/champion.json";
			HttpResponse<JsonNode> response5 = Unirest.get(url5).asJson();
			JSONObject champsObj = response5.getBody().getObject();
			JSONObject dataObj = champsObj.getJSONObject("data");
			Iterator<String> keys = dataObj.keys();
			while (keys.hasNext()) {
				String keyVal = keys.next();
				JSONObject champObj = dataObj.getJSONObject((String) keyVal);
				if (champObj.getLong("key") == champId) {
					String champName = keyVal;
					model.addAttribute("champPic",
							"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
				}
				if (champObj.getLong("key") == champId2) {
					String champName2 = keyVal;
					model.addAttribute("champPic2",
							"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName2 + ".png");
				}
				if (champObj.getLong("key") == champId3) {
					String champName3 = keyVal;
					model.addAttribute("champPic3",
							"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName3 + ".png");
				}
			}
		} catch (Exception Doh) {
			return "errorPage.jsp";
		}

		return "viewSummoner.jsp";
	}
	@RequestMapping("/summonerId{Id}")
	public String getSummonerId(@RequestParam("Id") String Id, Model model) throws Exception {
		try {
			String url = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/";
			String Origin = "https://developer.riotgames.com";
			String token = "KEEEEEY";
			String language = "en-US,en;q=0.9";
			String s = Id;

			HttpResponse<JsonNode> response = Unirest.get(url + s).header("Origin", Origin)
					.header("X-Riot-Token", token).header("Accept-Language", language).asJson();
			JSONObject myObj = response.getBody().getObject();
			String name = myObj.getString("name");
			String summonerId = myObj.getString("id");
			Long level = myObj.getLong("summonerLevel");
			int profileIcon = myObj.getInt("profileIconId");
			model.addAttribute("summonerId", summonerId);
			model.addAttribute("profileIcon",
					"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/profileicon/" + profileIcon + ".png");
			model.addAttribute("summonerName", name);
			model.addAttribute("summonerLevel", level);

			String url2 = "https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId;
			HttpResponse<JsonNode> response2 = Unirest.get(url2).header("Origin", Origin).header("X-Riot-Token", token)
					.header("Accept-Language", language).asJson();
			JSONArray myObj2 = response2.getBody().getArray();
			try {
				JSONObject soloQueue = myObj2.getJSONObject(0);
				String tier = soloQueue.getString("tier");
				boolean streak = soloQueue.getBoolean("hotStreak");
				int totalWins = soloQueue.getInt("wins");
				int totalLosses = soloQueue.getInt("losses");
				String division = soloQueue.getString("rank");
				int leaguePoints = soloQueue.getInt("leaguePoints");
				int totalGames = totalWins + totalLosses;
				float winPercent = (float) totalWins / totalGames * 100;
				model.addAttribute("winPercent", winPercent);
				model.addAttribute("tier", tier);
				model.addAttribute("streak", streak);
				model.addAttribute("totalWins", totalWins);
				model.addAttribute("totalLosses", totalLosses);
				model.addAttribute("division", division);
				model.addAttribute("leaguePoints", leaguePoints);
				model.addAttribute("totalGames", totalGames);
			} catch (Exception e) {
				System.out.println("No Solo Queue info");
			}
			try {
				JSONObject flexQueue = myObj2.getJSONObject(1);
				String tier2 = flexQueue.getString("tier");
				boolean streak2 = flexQueue.getBoolean("hotStreak");
				int totalWins2 = flexQueue.getInt("wins");
				int totalLosses2 = flexQueue.getInt("losses");
				String division2 = flexQueue.getString("rank");
				int leaguePoints2 = flexQueue.getInt("leaguePoints");
				int totalGames2 = totalWins2 + totalLosses2;
				float winPercent2 = (float) totalWins2 / totalGames2 * 100;
				model.addAttribute("winPercent2", winPercent2);
				model.addAttribute("tier2", tier2);
				model.addAttribute("streak2", streak2);
				model.addAttribute("totalWins2", totalWins2);
				model.addAttribute("totalLosses2", totalLosses2);
				model.addAttribute("division2", division2);
				model.addAttribute("leaguePoints2", leaguePoints2);
				model.addAttribute("totalGames2", totalGames2);
			} catch (Exception b) {
				System.out.println("No Flex Queue info");
			}
			try {
				String url3 = "https://na1.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/" + summonerId;
				HttpResponse<JsonNode> response3 = Unirest.get(url3).header("Origin", Origin)
						.header("X-Riot-Token", token).header("Accept-Language", language).asJson();
				JSONObject participantsObj = response3.getBody().getObject();
				String matchType = participantsObj.getString("gameMode");
				model.addAttribute("matchType", matchType);
				Long gameStart = participantsObj.getLong("gameStartTime");
				long epoch = System.currentTimeMillis()/1000;
				long gameLengthEpoch = epoch - gameStart/1000;
				long gameMinutes = (long) Math.floor(gameLengthEpoch/60);
				long gameSeconds = (long) Math.floor(gameLengthEpoch%60);
				String date = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date(gameStart));
				model.addAttribute("gameStart", date);
				model.addAttribute("gameMinutes", gameMinutes);
				model.addAttribute("gameSeconds", gameSeconds);
				JSONArray participants = participantsObj.getJSONArray("participants");
				JSONObject participant1 = participants.getJSONObject(0);
				Long participant1Champ = participant1.getLong("championId");
				String participant1Name = participant1.getString("summonerName");
				String participant1Id = participant1.getString("summonerId");
				model.addAttribute("participant1Name", participant1Name);
				model.addAttribute("participant1Id", participant1Id);
				JSONObject participant2 = participants.getJSONObject(1);
				Long participant2Champ = participant2.getLong("championId");
				String participant2Name = participant2.getString("summonerName");
				String participant2Id = participant2.getString("summonerId");
				model.addAttribute("participant2Name", participant2Name);
				model.addAttribute("participant2Id", participant2Id);
				JSONObject participant3 = participants.getJSONObject(2);
				Long participant3Champ = participant3.getLong("championId");
				String participant3Name = participant3.getString("summonerName");
				String participant3Id = participant3.getString("summonerId");
				model.addAttribute("participant3Name", participant3Name);
				model.addAttribute("participant3Id", participant3Id);
				JSONObject participant4 = participants.getJSONObject(3);
				Long participant4Champ = participant4.getLong("championId");
				String participant4Name = participant4.getString("summonerName");
				String participant4Id = participant4.getString("summonerId");
				model.addAttribute("participant4Name", participant4Name);
				model.addAttribute("participant4Id", participant4Id);
				JSONObject participant5 = participants.getJSONObject(4);
				Long participant5Champ = participant5.getLong("championId");
				String participant5Name = participant5.getString("summonerName");
				String participant5Id = participant5.getString("summonerId");
				model.addAttribute("participant5Name", participant5Name);
				model.addAttribute("participant5Id", participant5Id);
				JSONObject participant6 = participants.getJSONObject(5);
				Long participant6Champ = participant6.getLong("championId");
				String participant6Name = participant6.getString("summonerName");
				String participant6Id = participant6.getString("summonerId");
				model.addAttribute("participant6Name", participant6Name);
				model.addAttribute("participant6Id", participant6Id);
				JSONObject participant7 = participants.getJSONObject(6);
				Long participant7Champ = participant7.getLong("championId");
				String participant7Name = participant7.getString("summonerName");
				String participant7Id = participant7.getString("summonerId");
				model.addAttribute("participant7Name", participant7Name);
				model.addAttribute("participant7Id", participant7Id);
				JSONObject participant8 = participants.getJSONObject(7);
				Long participant8Champ = participant8.getLong("championId");
				String participant8Name = participant8.getString("summonerName");
				String participant8Id = participant8.getString("summonerId");
				model.addAttribute("participant8Name", participant8Name);
				model.addAttribute("participant8Id", participant8Id);
				JSONObject participant9 = participants.getJSONObject(8);
				Long participant9Champ = participant9.getLong("championId");
				String participant9Name = participant9.getString("summonerName");
				String participant9Id = participant9.getString("summonerId");
				model.addAttribute("participant9Name", participant9Name);
				model.addAttribute("participant9Id", participant9Id);
				JSONObject participant10 = participants.getJSONObject(9);
				Long participant10Champ = participant10.getLong("championId");
				String participant10Name = participant10.getString("summonerName");
				String participant10Id = participant10.getString("summonerId");
				model.addAttribute("participant10Name", participant10Name);
				model.addAttribute("participant10Id", participant10Id);
				String url6 = "http://ddragon.leagueoflegends.com/cdn/10.4.1/data/en_US/champion.json";
				HttpResponse<JsonNode> response6 = Unirest.get(url6).asJson();
				JSONObject gameChampsObj = response6.getBody().getObject();
				JSONObject dataObj = gameChampsObj.getJSONObject("data");
				Iterator<String> keys = dataObj.keys();
				while (keys.hasNext()) {
					String keyVal = keys.next();
					JSONObject champObj = dataObj.getJSONObject((String) keyVal);
					if (champObj.getLong("key") == participant1Champ) {
						String champName = keyVal;
						model.addAttribute("participant1Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant2Champ) {
						String champName = keyVal;
						model.addAttribute("participant2Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant3Champ) {
						String champName = keyVal;
						model.addAttribute("participant3Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant4Champ) {
						String champName = keyVal;
						model.addAttribute("participant4Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant5Champ) {
						String champName = keyVal;
						model.addAttribute("participant5Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant6Champ) {
						String champName = keyVal;
						model.addAttribute("participant6Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant7Champ) {
						String champName = keyVal;
						model.addAttribute("participant7Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant8Champ) {
						String champName = keyVal;
						model.addAttribute("participant8Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant9Champ) {
						String champName = keyVal;
						model.addAttribute("participant9Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
					if (champObj.getLong("key") == participant10Champ) {
						String champName = keyVal;
						model.addAttribute("participant10Champ",
								"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
					}
				}
			} catch (Exception n) {
				System.out.println("Not in game");
				model.addAttribute("notingame", "Summoner not currently in a game.");
			}
			String url4 = "https://na1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
					+ summonerId;
			HttpResponse<JsonNode> response4 = Unirest.get(url4).header("Origin", Origin).header("X-Riot-Token", token)
					.header("Accept-Language", language).asJson();
			JSONArray getChampIdObj = response4.getBody().getArray();
			JSONObject favoriteChampId = getChampIdObj.getJSONObject(0);
			Long champId = favoriteChampId.getLong("championId");
			int masteryPoints = favoriteChampId.getInt("championPoints");
			int championLevel = favoriteChampId.getInt("championLevel");
			model.addAttribute("masteryPoints", masteryPoints);
			model.addAttribute("championLevel", championLevel);
			JSONObject favoriteChampId2 = getChampIdObj.getJSONObject(1);
			Long champId2 = favoriteChampId2.getLong("championId");
			int masteryPoints2 = favoriteChampId2.getInt("championPoints");
			int championLevel2 = favoriteChampId2.getInt("championLevel");
			model.addAttribute("masteryPoints2", masteryPoints2);
			model.addAttribute("championLevel2", championLevel2);
			JSONObject favoriteChampId3 = getChampIdObj.getJSONObject(2);
			Long champId3 = favoriteChampId3.getLong("championId");
			int masteryPoints3 = favoriteChampId3.getInt("championPoints");
			int championLevel3 = favoriteChampId3.getInt("championLevel");
			model.addAttribute("masteryPoints3", masteryPoints3);
			model.addAttribute("championLevel3", championLevel3);

			String url5 = "http://ddragon.leagueoflegends.com/cdn/10.4.1/data/en_US/champion.json";
			HttpResponse<JsonNode> response5 = Unirest.get(url5).asJson();
			JSONObject champsObj = response5.getBody().getObject();
			JSONObject dataObj = champsObj.getJSONObject("data");
			Iterator<String> keys = dataObj.keys();
			while (keys.hasNext()) {
				String keyVal = keys.next();
				JSONObject champObj = dataObj.getJSONObject((String) keyVal);
				if (champObj.getLong("key") == champId) {
					String champName = keyVal;
					model.addAttribute("champPic",
							"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName + ".png");
				}
				if (champObj.getLong("key") == champId2) {
					String champName2 = keyVal;
					model.addAttribute("champPic2",
							"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName2 + ".png");
				}
				if (champObj.getLong("key") == champId3) {
					String champName3 = keyVal;
					model.addAttribute("champPic3",
							"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/champion/" + champName3 + ".png");
				}
			}
		} catch (Exception Doh) {
			return "errorPage.jsp";
		}

		return "viewSummoner.jsp";
	}
	@RequestMapping("/championName{Name}")
	public String getChamp2(@RequestParam("Name") String Name, Model model) throws Exception {
		String n = Name;
		String s = n.replaceAll("\\s", "");
		return "redirect:/champion?Name="+s;
	}

	@RequestMapping("/champion{Name}")
	public String getChamp(@RequestParam("Name") String Name, Model model) throws Exception {

		String url = "http://ddragon.leagueoflegends.com/cdn/10.4.1/data/en_US/champion/";
		String n = Name;
		String s = n.replaceAll("\\s", "");

		try {
			HttpResponse<JsonNode> response = Unirest.get(url + s + ".json").asJson();
			JSONObject myObj = response.getBody().getObject();
			JSONObject dataObj = myObj.getJSONObject("data");
			JSONObject champObj = dataObj.getJSONObject(Name);
			String name = champObj.getString("id");
			String skinsName = champObj.getString("name");
			model.addAttribute("skins", skinsName);
			String title = champObj.getString("title");
			String lore = champObj.getString("lore");
			JSONArray abilities = champObj.getJSONArray("spells");
			JSONArray skins = champObj.getJSONArray("skins");
			JSONArray tips = champObj.getJSONArray("allytips");
			JSONObject passive = champObj.getJSONObject("passive");
			JSONObject passiveImage = passive.getJSONObject("image");
			String passiveImagePic = passiveImage.getString("full");
			try {
				String tip1 = tips.getString(0);
				String tip2 = tips.getString(1);
				String tip3 = tips.getString(2);
				model.addAttribute("tip1", tip1);
				model.addAttribute("tip2", tip2);
				model.addAttribute("tip3", tip3);
			} catch (Exception e) {
				System.out.println("No allytips in array..");
			}
			JSONObject skins2 = skins.getJSONObject(1);
			try {
				JSONObject skins3 = skins.getJSONObject(2);
				String skins3Name = skins3.getString("name");
				model.addAttribute("skins3", skins3Name);
				model.addAttribute("champSplash2",
						"http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + s + "_2.jpg");
			} catch (Exception b) {
				System.out.println("Champ only has two skins..");
			}
			JSONObject spellQ = abilities.getJSONObject(0);
			JSONObject SpellQImage = spellQ.getJSONObject("image");
			String SpellQImagePic = SpellQImage.getString("full");
			JSONObject spellW = abilities.getJSONObject(1);
			JSONObject SpellWImage = spellW.getJSONObject("image");
			String SpellWImagePic = SpellWImage.getString("full");
			JSONObject spellE = abilities.getJSONObject(2);
			JSONObject SpellEImage = spellE.getJSONObject("image");
			String SpellEImagePic = SpellEImage.getString("full");
			JSONObject spellR = abilities.getJSONObject(3);
			JSONObject SpellRImage = spellR.getJSONObject("image");
			String skins2Name = skins2.getString("name");
			String SpellRImagePic = SpellRImage.getString("full");
			String spellQName = spellQ.getString("name");
			String spellWName = spellW.getString("name");
			String spellEName = spellE.getString("name");
			String spellRName = spellR.getString("name");
			String spellQDescription = spellQ.getString("description");
			String spellEDescription = spellE.getString("description");
			String spellWDescription = spellW.getString("description");
			String spellRDescription = spellR.getString("description");
			String passiveName = passive.getString("name");
			String passiveDescription = passive.getString("description");
			model.addAttribute("skins2", skins2Name);
			model.addAttribute("champSplash",
					"http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + s + "_0.jpg");
			model.addAttribute("champSplash1",
					"http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + s + "_1.jpg");
			model.addAttribute("spellQImagePic",
					"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/spell/" + SpellQImagePic);
			model.addAttribute("spellWImagePic",
					"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/spell/" + SpellWImagePic);
			model.addAttribute("spellEImagePic",
					"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/spell/" + SpellEImagePic);
			model.addAttribute("spellRImagePic",
					"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/spell/" + SpellRImagePic);
			model.addAttribute("passiveImagePic",
					"http://ddragon.leagueoflegends.com/cdn/10.4.1/img/passive/" + passiveImagePic);
			model.addAttribute("spellQDescription", spellQDescription);
			model.addAttribute("spellQName", spellQName);
			model.addAttribute("spellWDescription", spellWDescription);
			model.addAttribute("spellWName", spellWName);
			model.addAttribute("spellEDescription", spellEDescription);
			model.addAttribute("spellEName", spellEName);
			model.addAttribute("spellRDescription", spellRDescription);
			model.addAttribute("spellRName", spellRName);
			model.addAttribute("passiveName", passiveName);
			model.addAttribute("passiveDescription", passiveDescription);
			model.addAttribute("name", name);
			model.addAttribute("title", title);
			model.addAttribute("lore", lore);
		} catch (Exception oof) {
			return "errorPage2.jsp";
		}

		return "viewChamp.jsp";
	}
}
