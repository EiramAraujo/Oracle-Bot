package com.chiron.bot.specifications;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.chiron.bot.models.entities.Unit;

public class UnitSpecifications {
	public static Specification<Unit> idLike(Integer id){
		return (unit, cq,ci) -> Optional.ofNullable(id).map(i -> ci.equal(unit.get("id"), i)).orElse(null);
	}
	
	public static Specification<Unit> nameLike(String name){
		return (unit, cq,cn) -> Optional.ofNullable(name).map(n -> cn.like( cn.lower(unit.get("name")),"%" + n + "%")).orElse(null);
	}
	
	public static Specification<Unit> archetypeNameLike(String archName){
		return (unit, cq,ca) -> Optional.ofNullable(archName).map(a -> ca.like(ca.lower(unit.get("archetype").get("name")),"%" + a + "%")).orElse(null);
	}
	
	public static Specification<Unit> archetypeIDLike(Integer id){
		return (unit, cq,ca) -> Optional.ofNullable(id).map(a -> ca.equal(unit.get("archetype"), a)).orElse(null);
	}
	
	public static Specification<Unit> tierIDLike(Integer id){
		return (unit, cq,ct) -> Optional.ofNullable(id).map(t -> ct.equal(unit.get("tier"), t)).orElse(null);
	}

}
