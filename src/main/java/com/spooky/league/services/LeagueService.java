package com.spooky.league.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spooky.league.models.Comment;
import com.spooky.league.repositories.CommentRepository;

@Service
public class LeagueService {
	private final CommentRepository commentRepository;
	
	public LeagueService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	public List<Comment> allComments(){
		return commentRepository.findAll();
	}
}
