package com.devon.dojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devon.dojoOverflow.models.Answer;
import com.devon.dojoOverflow.models.Question;
import com.devon.dojoOverflow.models.Tag;
import com.devon.dojoOverflow.repositories.ARepo;
import com.devon.dojoOverflow.repositories.QRepo;
import com.devon.dojoOverflow.repositories.TRepo;

@Service
public class QService {
	private QRepo qRepo;
	private TRepo tRepo;
	private ARepo aRepo;
	public QService(QRepo qRepo, TRepo tRepo, ARepo aRepo) {
		this.qRepo = qRepo;
		this.tRepo = tRepo;
		this.aRepo = aRepo;
	}
	
	public List<Question> allQuestions(){
		return qRepo.findAll();
	}
	public Question questionById(Long id) {
		return qRepo.findById(id).orElse(null);
	}
	public Question addQuestion(Question question) {
		qRepo.save(question);
		return question;
	}
	public void addQuestionTag(Question question, Tag tag) {
		question.getTags().add(tag);
		qRepo.save(question);
		tRepo.save(tag);
	}
	public void addAnswer(Question question, Answer answer) {
		question.getAnswers().add(answer);
		qRepo.save(question);
		aRepo.save(answer);
	}
}
