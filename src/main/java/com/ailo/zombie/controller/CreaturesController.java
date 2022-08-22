package com.ailo.zombie.controller;

import com.ailo.zombie.model.dto.CreatureDTO;
import com.ailo.zombie.service.CreaturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/creatures")
@RequiredArgsConstructor
public class CreaturesController {

    private final CreaturesService creaturesService;

    @GetMapping(value = "/getAllCreatures")
    ResponseEntity<List<CreatureDTO>> getAllCreatures(){
        final List<CreatureDTO> creatureDTO = creaturesService.getAllCreatures();
        return new ResponseEntity<>(creatureDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/createCreature")
    ResponseEntity<CreatureDTO> createCreature(@RequestBody CreatureDTO creatureDTO){
        final CreatureDTO dto = creaturesService.createCreature(creatureDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/editCreatures/{id}")
    ResponseEntity<Void> updateCreature(@PathVariable int id, @RequestBody CreatureDTO creatureDTO){
        creaturesService.updateCreatures(id, creatureDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
