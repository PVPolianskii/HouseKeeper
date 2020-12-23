package dev.pvpolianskii.housekeeper.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocationRequest {

    @JsonProperty(value = "location_name")
    @NotEmpty
    private String locationName;

    @JsonProperty(value = "settlement_type")
    @NotEmpty
    private String settlementType;

    @JsonProperty(value = "settlement_name")
    @NotEmpty
    private String settlementName;

    @JsonProperty(value = "street")
    @NotEmpty
    private String street;

    @JsonProperty(value = "building")
    @NotEmpty
    private String building;

    @JsonProperty(value = "housing")
    private String housing;

    @JsonProperty(value = "apartment")
    private String apartment;
}
