package com.chiron.bot.models.DAOs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.chiron.bot.models.entities.Tier;


public interface TierDAO extends JpaRepository<Tier, Long>, JpaSpecificationExecutor<Tier> {
	public Optional<Tier> findById(Integer id);
}
