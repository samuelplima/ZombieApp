package com.ailo.zombie.controller;

import com.ailo.zombie.service.AppRunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zombie")
@RequiredArgsConstructor
public class ZombieController {

    private final AppRunService appRunService;

    @PostMapping(value = "/startChasing")
    public ResponseEntity<String> startChasing(){
        String msg = appRunService.invoke();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
