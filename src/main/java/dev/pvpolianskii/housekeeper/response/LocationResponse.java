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

        LocationResponse locationResponse = LocationResponse.builder()
                .name(location.getName())
                .settlementType(location.getSettlementType())
                .settlementName(location.getSettlementName())
                .street(location.getStreet())
                .building(location.getBuilding())
                .housing(location.getHousing())
                .apartment(location.getApartment())
                .build();

        return locationResponse;
    }


//    public LocationResponse(Location location) {
//        this.name = location.getName();
//        this.settlementType = location.getSettlementType();
//        this.settlementName = location.getSettlementName();
//        this.street = location.getStreet();
//        this.building = location.getBuilding();
//        this.housing = location.getHousing();
//        this.apartment = location.getApartment();
//
//    }
}
