package com.spooky.league.controllers;

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
	@RequestMapping("/summoner{Name}")
	public String getSummoner(@RequestParam("Name") String Name, Model model) throws Exception{

		String url = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
	    String Origin = "https://developer.riotgames.com";
	    String token = "KEEEEEEEEEEEEY";
	    String language = "en-US,en;q=0.9";
	    String s = Name;
	    
	    HttpResponse<JsonNode> response = Unirest.get(url + s)
	    	      .header("Origin", Origin)
	    	      .header("X-Riot-Token", token)
	    	      .header("Accept-Language", language)
	    	      .asJson();
	    JSONObject myObj = response.getBody().getObject();
	    String name = myObj.getString("name");
	    String summonerId = myObj.getString("id");
	    Long level = myObj.getLong("summonerLevel");
	    int profileIcon = myObj.getInt("profileIconId");
	    model.addAttribute("summonerId", summonerId);
	    model.addAttribute("profileIcon", "http://ddragon.leagueoflegends.com/cdn/10.4.1/img/profileicon/" + profileIcon + ".png");
	    model.addAttribute("summonerName", name);
	    model.addAttribute("summonerLevel", level);
	    
	    String url2 = "https://na1.api.riotgames.com/lol/league/v4/entries/by-summoner/" +summonerId;
	    HttpResponse<JsonNode> response2 = Unirest.get(url2)
	    	      .header("Origin", Origin)
	    	      .header("X-Riot-Token", token)
	    	      .header("Accept-Language", language)
	    	      .asJson();
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
	    float winPercent = (float) totalWins/totalGames * 100;
	    model.addAttribute("winPercent", winPercent);
	    model.addAttribute("tier", tier);
	    model.addAttribute("streak", streak);
	    model.addAttribute("totalWins", totalWins);
	    model.addAttribute("totalLosses", totalLosses);
	    model.addAttribute("division", division);
	    model.addAttribute("leaguePoints", leaguePoints);
	    model.addAttribute("totalGames", totalGames);
	    }
	    catch(Exception e) {
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
		    float winPercent2 = (float) totalWins2/totalGames2 * 100;
		    model.addAttribute("winPercent2", winPercent2);
		    model.addAttribute("tier2", tier2);
		    model.addAttribute("streak2", streak2);
		    model.addAttribute("totalWins2", totalWins2);
		    model.addAttribute("totalLosses2", totalLosses2);
		    model.addAttribute("division2", division2);
		    model.addAttribute("leaguePoints2", leaguePoints2);
		    model.addAttribute("totalGames2", totalGames2);
	    }
	    catch(Exception b) {
	    	System.out.println("No Flex Queue info");
	    }
	    return "viewSummoner.jsp";
	}
	@RequestMapping("/champion{Name}")
	public String getChamp(@RequestParam("Name") String Name, Model model) throws Exception{

		String url = "http://ddragon.leagueoflegends.com/cdn/10.4.1/data/en_US/champion/";
	    String s = Name;
	    
	    HttpResponse<JsonNode> response = Unirest.get(url + s + ".json")
	    	      .asJson();
	    JSONObject myObj = response.getBody().getObject();
	    JSONObject dataObj = myObj.getJSONObject("data");
	    JSONObject champObj = dataObj.getJSONObject(Name);
	    String name = champObj.getString("id");
	    String title = champObj.getString("title");
	    String lore = champObj.getString("lore");
	    JSONArray abilities = champObj.getJSONArray("spells");
	    JSONArray skins = champObj.getJSONArray("skins");
	    JSONArray tips = champObj.getJSONArray("allytips");
	    JSONObject passive = champObj.getJSONObject("passive");
	    JSONObject passiveImage = passive.getJSONObject("image");
	    String passiveImagePic = passiveImage.getString("full");
	    try{ String tip1 = tips.getString(0);
	    String tip2 = tips.getString(1);
	    String tip3 = tips.getString(2);
	    model.addAttribute("tip1", tip1);
	    model.addAttribute("tip2", tip2);
	    model.addAttribute("tip3", tip3);
	    }
	    catch (Exception e){
	    	System.out.println("No allytips in array..");
	    }
	    JSONObject skins2 = skins.getJSONObject(1);
	    try {
	    JSONObject skins3 = skins.getJSONObject(2);
	    String skins3Name = skins3.getString("name");
	    model.addAttribute("skins3", skins3Name);
	    model.addAttribute("champSplash2", "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" +s+"_2.jpg");
	    }
	    catch (Exception b) {
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
	    model.addAttribute("champSplash", "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" +s+"_0.jpg");
	    model.addAttribute("champSplash1", "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" +s+"_1.jpg");
	    model.addAttribute("spellQImagePic", "http://ddragon.leagueoflegends.com/cdn/10.4.1/img/spell/" +SpellQImagePic);
	    model.addAttribute("spellWImagePic", "http://ddragon.leagueoflegends.com/cdn/10.4.1/img/spell/" +SpellWImagePic);
	    model.addAttribute("spellEImagePic", "http://ddragon.leagueoflegends.com/cdn/10.4.1/img/spell/" +SpellEImagePic);
	    model.addAttribute("spellRImagePic", "http://ddragon.leagueoflegends.com/cdn/10.4.1/img/spell/" +SpellRImagePic);
	    model.addAttribute("passiveImagePic", "http://ddragon.leagueoflegends.com/cdn/10.4.1/img/passive/" +passiveImagePic);
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
	    return "viewChamp.jsp";
	}
}
