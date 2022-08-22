package com.ailo.zombie.repository;

import com.ailo.zombie.model.entities.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureRepository extends JpaRepository<Creature, Integer> {


}
