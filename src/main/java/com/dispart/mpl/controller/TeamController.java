package com.dispart.mpl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

    @GetMapping
    ResponseEntity<String> getTeam() {
        return ResponseEntity.ok().body("Team is ready");
    }

}
