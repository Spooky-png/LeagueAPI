package com.spooky.league.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.spooky.league.services.LeagueService;

@RestController
public class LeagueAPI {
	private final LeagueService leagueService;
	public LeagueAPI(LeagueService leagueService) {
		this.leagueService = leagueService;
	}
	@RequestMapping("/api/summoner{Name}")
	public String getSummoner(@RequestParam("Name") String Name) throws Exception{

		String url = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
	    String Origin = "https://developer.riotgames.com";
	    String token = "KEEEEEEEEY";//Type here your key
	    String language = "en-US,en;q=0.9";
	    String s = Name;
	    
	    HttpResponse<JsonNode> response = Unirest.get(url + s)
	    	      .header("Origin", Origin)
	    	      .header("X-Riot-Token", token)
	    	      .header("Accept-Language", language)
	    	      .asJson();
	    System.out.println(response.getStatus());
	    System.out.println(response.getBody().toString());
	    System.out.println(response.getHeaders().get("Content-Type"));
	    return response.getBody().toString();
	}
	@RequestMapping("/api/champion{Name}")
	public String getChamp(@RequestParam("Name") String Name) throws Exception{

		String url = "http://ddragon.leagueoflegends.com/cdn/10.4.1/data/en_US/champion/";
	    String s = Name;
	    
	    HttpResponse<JsonNode> response = Unirest.get(url + s + ".json")
	    	      .asJson();
	    System.out.println(response.getStatus());
	    System.out.println(response.getBody().toString());
	    System.out.println(response.getHeaders().get("Content-Type"));
	    return response.getBody().toString();
	}
    
}
