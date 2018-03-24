package com.devon.lookify.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devon.lookify.models.Song;
import com.devon.lookify.services.LService;

@Controller
@RequestMapping("/")
public class LookController {
	private final LService lService;
	public LookController(LService lService) {
		this.lService = lService;
	}
	@RequestMapping("")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/dash")
	public String showDash(@ModelAttribute("song")Song song, Model model) {
		ArrayList<Song> songs = lService.allSongs();
		model.addAttribute("songs", songs);
		return "dash.jsp";
	}
	@RequestMapping("/new")
	public String addSong(@ModelAttribute("song")Song song) {
		return "addSong.jsp";
	}
	@RequestMapping("/create")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return "addSong.jsp";
		}else {
		lService.addSong(song);
		return "redirect:/dash";
		}
	}
	@RequestMapping("/showSong/{id}")
	public String showSong(Model model, @PathVariable("id") Long id) {
		Song song = lService.findSongById(id);
		model.addAttribute("song",song);
		return "showSong.jsp";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		lService.deleteSong(id);
		return("redirect:/dash");
	}
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public String searchArtist(@RequestParam(value="artist")String artist, Model model) {
		if(lService.songArtist(artist).size() <= 0) {
			model.addAttribute("error" ,"artist not found");
			System.out.println(lService.songArtist(artist));
			return("redirect:/dash");
		}
		ArrayList<Song> song = lService.songArtist(artist);
		model.addAttribute("artist", song);
		return("showArtist.jsp");
	}
	@RequestMapping("/top")
	public String topTen(Model model) {
		ArrayList<Song> songs = lService.topTen();
		model.addAttribute("songs",songs);
		return("topTen.jsp");
	}
}
