package com.chiron.bot.models.entities;

import org.springframework.beans.factory.FactoryBean;

public class ArchetypeFactory implements FactoryBean<Archetype>{

	@Override
	public Archetype getObject() throws Exception {
		return new Archetype();
	}

	@Override
	public Class<?> getObjectType() {
		return Archetype.class;
	}
}
