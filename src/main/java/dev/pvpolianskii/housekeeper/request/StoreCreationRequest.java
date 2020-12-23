package dev.pvpolianskii.housekeeper.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreCreationRequest {

    @JsonProperty(value = "storeName")
    @NotEmpty
    private String storeName;

    @JsonProperty(value = "locationId")
    @NotNull
    @Positive
    private Long locationId;

}
