package dev.pvpolianskii.housekeeper.response;


import dev.pvpolianskii.housekeeper.model.Location;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class LocationResponse {

    private String name;
    private String settlementType;
    private String settlementName;
    private String street;
    private String building;
    private String housing;
    private String apartment;


    public static LocationResponse fromEntity(Location location) {

        return LocationResponse.builder()
                .name(location.getName())
                .settlementType(location.getSettlementType())
                .settlementName(location.getSettlementName())
                .street(location.getStreet())
                .building(location.getBuilding())
                .housing(location.getHousing())
                .apartment(location.getApartment())
                .build();
    }


}
