package com.devon.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devon.dojoOverflow.models.Tag;
import com.devon.dojoOverflow.repositories.TRepo;

@Service
public class TService {
	private TRepo tRepo;
	public TService(TRepo tRepo) {
		this.tRepo = tRepo;
	}
	
	public List<Tag> allTags(){
		return tRepo.findAll();
	}
	public Tag findTagById(Long id) {
		return tRepo.findById(id).orElse(null);
	}
	public Tag addTag(Tag tag) {
		tRepo.save(tag);
		return tag;
	}

	public List<String> allTagNames() {
		List<String> names = new ArrayList<String>();
		for(Tag val:tRepo.findAll()) {
			names.add(val.getSubject());
		}
		return names;
	}
	public Tag findTagByName(String tag) {
		for(Tag val:tRepo.findAll()) {
			if(val.getSubject().equals(tag)) {
				return val;
			} 
		}
		return null;
	}
	
}
