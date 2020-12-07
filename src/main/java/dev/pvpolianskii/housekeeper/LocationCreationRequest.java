package dev.pvpolianskii.housekeeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocationCreationRequest {

    @JsonProperty(value = "storeName")
    @NotEmpty
    private String storeName;

    @JsonProperty(value = "location")
    @NotEmpty
    @Positive
    private Long locationId;
}
