package com.devon.groupLanguages2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Language {
	
	@Id
    @GeneratedValue
    private Long id;
	@Column
	@Size(min = 3, max = 20)
	private String name;
	@Column
	@Size(min = 3, max = 20)
	private String creator;
	@Column
	@NotNull
	private String version;
	
	public Language() {
		
	}
	
	public Language(Long id, @Size(min = 3, max = 20) String name, @Size(min = 3, max = 20) String creator,
			@NotNull String version) {
		super();
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
