package dev.pvpolianskii.housekeeper.model;

import dev.pvpolianskii.housekeeper.request.LocationRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
@Getter
@Setter

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "settlement_type")
    private String settlementType;

    @Column(name = "settlement_name")
    private String settlementName;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @Column(name = "housing")
    private String housing;

    @Column(name = "apartment")
    private String apartment;

    @OneToMany(mappedBy = "location")
    private List<Store> store = new ArrayList<>();

    public void locationSet(LocationRequest locationRequest) {

        this.name = locationRequest.getLocationName();
        this.settlementType = locationRequest.getSettlementType();
        this.settlementName = locationRequest.getSettlementName();
        setStreet(locationRequest.getStreet());
        setBuilding(locationRequest.getBuilding());
        setHousing(locationRequest.getHousing());
        setApartment(locationRequest.getApartment());



    }


}
