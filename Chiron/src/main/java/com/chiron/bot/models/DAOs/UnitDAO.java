package com.chiron.bot.models.DAOs;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.chiron.bot.models.entities.Unit;

@Repository
public interface UnitDAO extends JpaRepository<Unit, Long>, JpaSpecificationExecutor<Unit> {
	Optional<Unit> findByNameIgnoreCase(String name);
	List<Unit> findByArchetype_NameAndTier_IdAllIgnoreCase(String archId,Integer tierId);
	List<Unit> findByTier_Id(Integer tierId);
	List<Unit> findByArchetype_NameIgnoreCase(String archId);
}
