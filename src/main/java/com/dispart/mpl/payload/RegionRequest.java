package com.dispart.mpl.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
public record RegionRequest(
        Long id,
        @NotNull(message = "Country name cannot be null") String country
) {
}
