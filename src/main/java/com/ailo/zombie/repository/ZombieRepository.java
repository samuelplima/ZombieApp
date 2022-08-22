package com.ailo.zombie.repository;

import com.ailo.zombie.model.entities.Zombie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZombieRepository extends JpaRepository<Zombie, Integer> {

}
