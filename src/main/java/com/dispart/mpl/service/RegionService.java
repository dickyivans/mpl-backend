package com.dispart.mpl.service;

import com.dispart.mpl.entity.Region;
import com.dispart.mpl.mapper.RegionMapper;
import com.dispart.mpl.payload.RegionRequest;
import com.dispart.mpl.payload.RegionResponse;
import com.dispart.mpl.repository.RegionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    public RegionResponse createRegion(RegionRequest request) {
        var region = regionMapper.toRegion(request);
        return this.regionMapper.toRegionResponse(regionRepository.save(region));
    }

    public RegionResponse getRegion(Long id) {
        return this.regionMapper.toRegionResponse(regionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Region not found")));
    }

    public List<RegionResponse> getRegions() {
        return regionRepository.findAll()
                .stream()
                .map(this.regionMapper::toRegionResponse)
                .collect(Collectors.toList());
    }

    public RegionResponse updateRegion(Long id, RegionRequest regionRequest) {
        Region oldRegion = regionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Region not found"));
        if (oldRegion != null) {
            return this.regionMapper.toRegionResponse(regionRepository.save(regionMapper.toRegion(regionRequest)));
        }
        return null;
    }

    public void deleteRegion(Long id) {
        Region region = regionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Region not found"));
        if (region != null) {
            regionRepository.delete(region);
        }
    }
}
