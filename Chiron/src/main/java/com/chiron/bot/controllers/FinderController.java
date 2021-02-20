package com.chiron.bot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chiron.bot.models.ArchetypeDTO;
import com.chiron.bot.models.TierDTO;
import com.chiron.bot.models.UnitDTO;
import com.chiron.bot.models.DAOs.ArchetypeDAO;
import com.chiron.bot.models.DAOs.TierDAO;
import com.chiron.bot.models.DAOs.UnitDAO;
import com.chiron.bot.models.entities.Archetype;
import com.chiron.bot.models.entities.Tier;
import com.chiron.bot.models.entities.Unit;
import com.chiron.bot.specifications.UnitSpecifications;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FinderController {
	@Autowired
	UnitDAO unitDAO;
	@Autowired
	ArchetypeDAO archetypeDAO;
	@Autowired
	TierDAO tierDAO;
	
	@GetMapping({"/test/{name}"})
	String searchTest(@PathVariable String name) throws JsonProcessingException {
		//Optional<Unit> result = unitDAO.findOne(Specification.where(Specification.where(UnitSpecifications.nameLike(name.toLowerCase()))));
		
		Optional<Unit> result = unitDAO.findByNameIgnoreCase(name);
		if(!result.isPresent()) return null;
		
		ArchetypeDTO arch = new ArchetypeDTO();
		TierDTO tier = new TierDTO();
		
		BeanUtils.copyProperties(result.get().getArchetype(), arch);
		BeanUtils.copyProperties(result.get().getTier(), tier);
		UnitDTO unitDTO = new UnitDTO(result.get().getId(),result.get().getName(), arch, tier); 
		
		ObjectMapper objectMapper = new ObjectMapper();
		String JSONunit = objectMapper.writeValueAsString(unitDTO);
		
		return JSONunit;
	}
	
	@GetMapping({"/unit/{name}"})
	String searchUnit(@PathVariable String name) throws JsonProcessingException {
		Optional<Unit> result = unitDAO.findOne(Specification.where(Specification.where(UnitSpecifications.nameLike(name.toLowerCase()))));
		//Optional<Unit> result = unitDAO.findByNameIgnoreCase(name);
		if(!result.isPresent()) return null;
		
		ArchetypeDTO arch = new ArchetypeDTO();
		TierDTO tier = new TierDTO();
		
		BeanUtils.copyProperties(result.get().getArchetype(), arch);
		BeanUtils.copyProperties(result.get().getTier(), tier);
		UnitDTO unitDTO = new UnitDTO(result.get().getId(),result.get().getName(), arch, tier); 
		
		ObjectMapper objectMapper = new ObjectMapper();
		String JSONunit = objectMapper.writeValueAsString(unitDTO);
		
		return JSONunit;
	}
	
	@GetMapping({"/unitList"})
	String searchUnits(@RequestParam(required = false) String archId, @RequestParam(required = false) Integer tierId) throws JsonProcessingException {
		archId = archId.isEmpty() ? null : archId.toLowerCase();
		List<Unit> entities = unitDAO.findAll(Specification.where(UnitSpecifications.archetypeNameLike(archId).and(UnitSpecifications.tierIDLike(tierId))));
		//List<Unit> preResult = unitDAO.findByArchetype_NameAndTier_IdAllIgnoreCase(archId, tierId);
		
		
		List<UnitDTO> result = new ArrayList<>();
		entities.forEach((u) -> {
			ArchetypeDTO arch = new ArchetypeDTO(u.getArchetype().getId(),u.getArchetype().getName());
			TierDTO tier = new TierDTO(u.getTier().getId(),u.getTier().getName(),u.getTier().getColor());
			UnitDTO target = new UnitDTO(u.getId(),u.getName(), arch, tier);  	
			result.add(target);
		});
		
		//BeanUtils.copyProperties(result, target);\
		ObjectMapper objectMapper = new ObjectMapper();
		String JSONresult = objectMapper.writeValueAsString(result);
		//System.out.print(JSONresult);
		return JSONresult;
	}
	
	@GetMapping({"/tiers"})
	String searchTiers() throws JsonProcessingException {
		List<Tier> entities = tierDAO.findAll();
		
		List<TierDTO> result = new ArrayList<>();
		entities.forEach((t) -> {
			TierDTO target = new TierDTO();
			BeanUtils.copyProperties(t, target);
			result.add(target);
		});
		
		ObjectMapper objectMapper = new ObjectMapper();
		String JSONresult = objectMapper.writeValueAsString(result);
		
		return JSONresult;
	}
	
	@GetMapping({"/archetypes"})
	String searchArchetypes() throws JsonProcessingException {
		List<Archetype> entities = archetypeDAO.findAll();
		
		List<ArchetypeDTO> result = new ArrayList<>();
		entities.forEach((a) -> {
			ArchetypeDTO target = new ArchetypeDTO();
			BeanUtils.copyProperties(a, target);
			result.add(target);
		});
		
		ObjectMapper objectMapper = new ObjectMapper();
		String JSONresult = objectMapper.writeValueAsString(result);
		
		return JSONresult;
	}
}
