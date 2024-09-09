package com.dispart.mpl.controller.admin;

import com.dispart.mpl.payload.RegionRequest;
import com.dispart.mpl.payload.RegionResponse;
import com.dispart.mpl.service.RegionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${mpl.admin.resource.path.base}/region")
@RequiredArgsConstructor
public class AdminRegionController {
    private final RegionService regionService;

    @PostMapping
    ResponseEntity<RegionResponse> addRegion(@RequestBody @Valid RegionRequest regionRequest) {
        return ResponseEntity.ok(regionService.createRegion(regionRequest));
    }

    @GetMapping
    ResponseEntity<List<RegionResponse>> getRegions() {
        return ResponseEntity.ok(regionService.getRegions());
    }

    @GetMapping
    ResponseEntity<RegionResponse> getRegion(@RequestParam Long regionId) {
        return ResponseEntity.ok(regionService.getRegion(regionId));
    }

    @PutMapping
    ResponseEntity<RegionResponse> updateRegion(@RequestBody @Valid RegionRequest regionRequest) {
        return ResponseEntity.ok(regionService.updateRegion(regionRequest.id(), regionRequest));
    }

    @DeleteMapping
    ResponseEntity<Map<String, Boolean>> deleteRegion(@RequestParam Long regionId) {
        regionService.deleteRegion(regionId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
