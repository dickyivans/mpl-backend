package com.dispart.mpl.mapper;

import com.dispart.mpl.entity.Region;
import com.dispart.mpl.payload.RegionRequest;
import com.dispart.mpl.payload.RegionResponse;
import org.springframework.stereotype.Service;

@Service
public class RegionMapper {
    public Region toRegion(RegionRequest regionRequest) {
        if (regionRequest == null) {
            return null;
        }

        return Region.builder()
                .id(regionRequest.id())
                .country(regionRequest.country())
                .build();

    }

    public RegionResponse toRegionResponse(Region region) {
        return new RegionResponse(
                region.getId(), region.getCountry()
        );
    }
}
