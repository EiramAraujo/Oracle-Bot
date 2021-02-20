package com.chiron.bot.models.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Tier")
public class Tier {
	@Id
	private Integer id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String color;
	
	@OneToMany(mappedBy="tier", targetEntity = com.chiron.bot.models.entities.Unit.class)
	private Set<Unit> unit;
	
	protected Tier() {}
	
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
	public Set<Unit> getUnit() {
		return unit;
	}
	public void setUnit(Set<Unit> unit) {
		this.unit = unit;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
