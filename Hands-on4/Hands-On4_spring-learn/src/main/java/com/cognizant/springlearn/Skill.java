package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Skill {
	@NotNull
	@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Should be a Number")
	private int id;
	@NotNull
	@Size(min=1,max=30)
	private String name;
	
	public Skill() {
		super();
	}
	
	public Skill(@NotNull @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message = "Should be a Number") int id,
			@NotNull @Size(min = 1, max = 30) String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
