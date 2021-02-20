package com.chiron.bot.models;

public class UnitDTO {
	private Integer id;
	private String name;
	private ArchetypeDTO archetype;
	private TierDTO tier;

	public UnitDTO() {}
	
	public UnitDTO(Integer id, String name, ArchetypeDTO archetype, TierDTO tier) {
		this.id = id;
		this.name = name;
		this.archetype = archetype;
		this.tier = tier;
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

	public ArchetypeDTO getArchetype() {
		return archetype;
	}

	public void setArchetype(ArchetypeDTO archetype) {
		this.archetype = archetype;
	}

	public TierDTO getTier() {
		return tier;
	}

	public void setTier(TierDTO tier) {
		this.tier = tier;
	}
}
