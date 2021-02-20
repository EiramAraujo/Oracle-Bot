package com.chiron.bot.models.entities;

import org.springframework.beans.factory.FactoryBean;

public class TierFactory implements FactoryBean<Tier>{

	@Override
	public Tier getObject() throws Exception {
		return new Tier();
	}

	@Override
	public Class<?> getObjectType() {
		return Tier.class;
	}
	
}
