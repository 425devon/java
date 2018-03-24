package com.devon.dojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devon.dojoOverflow.models.Answer;
import com.devon.dojoOverflow.repositories.ARepo;

@Service
public class AService {
	private ARepo aRepo;
	public AService(ARepo aRepo) {
		this.aRepo = aRepo;
	}
	
	public List<Answer> allAnswers(){
		return aRepo.findAll();
	}
	public Answer answerById(Long id) {
		return aRepo.findById(id).orElse(null);
	}
	public Answer newAnswer(Answer answer) {
		aRepo.save(answer);
		return answer;
	}
	
}
