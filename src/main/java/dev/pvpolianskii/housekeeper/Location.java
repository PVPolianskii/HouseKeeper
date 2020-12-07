package dev.pvpolianskii.housekeeper;

import javax.persistence.*;

@Entity
@Table(name = "location")

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
    private Integer apartment;

}
