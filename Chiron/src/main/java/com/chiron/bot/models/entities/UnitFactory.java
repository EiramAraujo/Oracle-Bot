package com.chiron.bot.models.entities;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class UnitFactory implements FactoryBean<Unit>{

	@Override
	@Bean
	@Scope("singleton")
	public Unit getObject() throws Exception {
		return new Unit();
	}

	@Override
	public Class<?> getObjectType() {
		return Unit.class;
	}
	

}
