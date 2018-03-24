package com.devon.dojoninja.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devon.dojoninja.models.Dojo;
import com.devon.dojoninja.models.Ninja;
import com.devon.dojoninja.repositories.DRepo;
import com.devon.dojoninja.repositories.NRepo;

@Service
public class NService {
	private DRepo dRepo;
	private NRepo nRepo;
	public NService(DRepo dRepo, NRepo nRepo) {
		this.dRepo = dRepo;
		this.nRepo = nRepo;
	}
	
	public ArrayList<Dojo> allDojos(){
		return dRepo.findAll();
	}
	public ArrayList<Ninja> allNinjas(){
		return nRepo.findAll();
	}
	public void addDojo(Dojo dojo) {
		dRepo.save(dojo);
	}
	public void addNinja(Ninja ninja) {
		nRepo.save(ninja);
	}
	public Dojo findDojoById(Long id) {
		return dRepo.findById(id).orElse(null);
	}
}
