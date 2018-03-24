package com.devon.license.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devon.license.models.License;
import com.devon.license.models.Person;
import com.devon.license.repositories.LRepo;
import com.devon.license.repositories.PRepo;



@Service
public class LService {
	private PRepo pRepo;
	private LRepo lRepo;
	public LService(PRepo pRepo, LRepo lRepo) {
		this.pRepo = pRepo;
		this.lRepo = lRepo;
	}
	
	public ArrayList<Person> allPeople(){
		return pRepo.findAll();
	}
	public ArrayList<License> allLicense(){
		return lRepo.findAll();
	}
	public void addPerson(Person person) {
		pRepo.save(person);
	}
	public void addLicense(License license) {
		license.setNumber();
		lRepo.save(license);
		license.incNum();
	}
	public Person findByID(Long id) {
		return pRepo.findById(id).orElse(null);
	}
}
