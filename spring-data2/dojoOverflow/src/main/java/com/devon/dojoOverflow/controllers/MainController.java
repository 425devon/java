package com.devon.dojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devon.dojoOverflow.models.Answer;
import com.devon.dojoOverflow.models.Question;
import com.devon.dojoOverflow.models.Tag;
import com.devon.dojoOverflow.services.AService;
import com.devon.dojoOverflow.services.QService;
import com.devon.dojoOverflow.services.TService;

@Controller
@RequestMapping("/")
public class MainController {
	private final AService aService;
	private final QService qService;
	private final TService tService;
	
	public MainController(AService aService, QService qService, TService tService) {
		this.aService = aService;
		this.qService = qService;
		this.tService = tService;
	}
	@RequestMapping("")
	public String home(Model model) {
		List<Question> questions = qService.allQuestions();
		model.addAttribute("questions", questions);
		return("dash.jsp");
	}
	@RequestMapping("/newQuestion")
	public String newQuestion(@ModelAttribute("newQ")Question question) {
		return ("newQuestion.jsp");
	}
	@RequestMapping("/createQuestion")
	public String createQuestion(@Valid @ModelAttribute("newQ")Question question, BindingResult result, @RequestParam("tag")String tag) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return ("newQuestion.jsp");
		}	
		Question curQ = qService.addQuestion(question);
		//if multiple tags split into string list
		if(tag.contains(",")) {
			String[]tags = tag.split(",");
			for(int i = 0; (i < tags.length)&& (tags[i] != null); i++) {
				//if tag is not in db
				if(tService.allTagNames().contains(tags[i]) == false ){
					Tag newTag = tService.addTag(new Tag(tags[i]));
					qService.addQuestionTag(curQ, newTag);
				}else {
					qService.addQuestionTag(curQ, tService.findTagByName(tags[i]));
				}
			}
		//if single tag passed
		}else{
			if(tService.allTagNames().contains(tag) == false ) {
				Tag newTag = tService.addTag(new Tag(tag));
				qService.addQuestionTag(curQ, newTag);
			}else {
				qService.addQuestionTag(curQ, tService.findTagByName(tag));
			}
		}
		return ("redirect:/");
	}
	@RequestMapping("/{id}")
	public String showQuestion(@PathVariable("id")Long id, @ModelAttribute("answer")Answer answer, Model model) {
		Question curQ = qService.questionById(id);
		model.addAttribute("question", curQ);
		return("showQuestion.jsp");
	}
	@RequestMapping("/createAnswer/{id}")
	public String createAnswer(@Valid @ModelAttribute("answer")Answer answer, BindingResult result,@PathVariable("id")Long qid) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return ("redirect:/"+qid);
		}	
		Question curQ = qService.questionById(qid);
		answer.setQuestion(curQ);
		Answer curA = aService.newAnswer(answer);
		//qService.addAnswer(curQ, curA);
		
		System.out.println(qid);
		System.out.println(answer);
		System.out.println(qService.questionById(qid));
		return("redirect:/"+qid);

	}

}
