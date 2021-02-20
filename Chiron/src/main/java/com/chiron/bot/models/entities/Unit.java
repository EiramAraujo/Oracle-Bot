package com.chiron.bot.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Unit")
public class Unit {
	@Id
	private Integer id;
	@NotEmpty
	private String name;
	
	@ManyToOne(targetEntity = com.chiron.bot.models.entities.Archetype.class)
	@JoinColumn(name = "arch_id", nullable = false)
	private Archetype archetype;
	
	@ManyToOne(targetEntity = com.chiron.bot.models.entities.Tier.class)
	@JoinColumn(name = "tier_id", nullable = false)
	private Tier tier;
	
	protected Unit() {}

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

	public Archetype getArchetype() {
		return archetype;
	}

	public void setArchetype(Archetype archetype) {
		this.archetype = archetype;
	}

	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}
}
