package com.chiron.bot.models.DAOs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.chiron.bot.models.entities.Archetype;


public interface ArchetypeDAO extends JpaRepository<Archetype, Long>, JpaSpecificationExecutor<Archetype> {
	public Optional<Archetype> findById(Integer id);
}
