package com.chiron.bot.models.entities;



import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Archetype")
public class Archetype {
	
	@Id
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@OneToMany(mappedBy="archetype",  targetEntity = com.chiron.bot.models.entities.Unit.class)
	private Set<Unit> unit;
	
	protected Archetype() {}
	
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
	
}
