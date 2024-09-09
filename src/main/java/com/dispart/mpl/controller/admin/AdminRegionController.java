package com.dispart.mpl.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${mpl.admin.resource.path.base}/region")
public class AdminRegionController {

    @GetMapping
    public ResponseEntity<String> getRegions() {
        return ResponseEntity.ok("Regions Controller");
    }
}
