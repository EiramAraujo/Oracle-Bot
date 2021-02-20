package com.chiron.bot.models;

public class TierDTO {
	private Integer id;
	private String name;
	private String color;
	
	
	public TierDTO() {}
	
	public TierDTO(Integer id, String name, String color) {
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
