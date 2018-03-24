package com.devon.auth.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue
    private Long id;
	@Size(min=2, message="Email must be greater than 2 characters")
    private String username;
	@Size(min=2, message="first name must be greater than 2 characters")
    private String first_name;
	@Size(min=2, message="first name must be greater than 2 characters")
    private String last_name;
	@Size(min=2, message="please choose a state")
    private String state;
	@Size(min=2, message="location must not be blank")
    private String location;
	@Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //login auth roles
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @javax.persistence.JoinColumn (name = "user_id"), 
        inverseJoinColumns = @javax.persistence.JoinColumn (name = "role_id"))
    private List<Role> roles;
    
    //one user has many comments
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Comment> comments;
    
    //one user has many events
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name="users_events",
    		joinColumns = @javax.persistence.JoinColumn (name = "user_id"),
    		inverseJoinColumns = @javax.persistence.JoinColumn (name = "event_id"))
    private List<Event> events = new ArrayList<Event>();
    
    
    
    public User() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }
    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public String currentRole() {
    	List<Role> roles = this.getRoles();
    	return roles.get(0).getName();
    }
    public Long roleId() {
    	List<Role> roles = this.getRoles();
    	return roles.get(0).getId();
    }
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    /*@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }*/
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
