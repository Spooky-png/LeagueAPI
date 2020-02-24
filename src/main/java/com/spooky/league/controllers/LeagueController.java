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
	    String token = "KEEEEEEEEEY";
	    String language = "en-US,en;q=0.9";
	    String s = Name;
	    
	    HttpResponse<JsonNode> response = Unirest.get(url + s)
	    	      .header("Origin", Origin)
	    	      .header("X-Riot-Token", token)
	    	      .header("Accept-Language", language)
	    	      .asJson();
	    JSONObject myObj = response.getBody().getObject();
	    String msg = myObj.getString("accountId");
	    Long level = myObj.getLong("summonerLevel");
	    System.out.println(response.getStatus());
	    System.out.println(response.getBody().toString());
	    System.out.println(response.getHeaders().get("Content-Type"));
	    model.addAttribute("summoner", msg);
	    model.addAttribute("summonerLevel", level);
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
	    JSONObject spellQ = abilities.getJSONObject(0);
	    String spellQName = spellQ.getString("name");
	    String spellQDescription = spellQ.getString("description");
	    System.out.println(response.getStatus());
	    System.out.println(response.getBody().getObject());
	    System.out.println(response.getHeaders().get("Content-Type"));
	    model.addAttribute("spellQDescription", spellQDescription);
	    model.addAttribute("spellQName", spellQName);
	    model.addAttribute("name", name);
	    model.addAttribute("title", title);
	    model.addAttribute("lore", lore);
	    return "viewChamp.jsp";
	}
}
