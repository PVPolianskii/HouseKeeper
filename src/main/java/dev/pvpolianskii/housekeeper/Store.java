package dev.pvpolianskii.housekeeper;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@Setter

public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location_id")
    private Long locationId;

    @OneToMany(mappedBy = "store")
    private List<GoodsInStore> listGoodsInStore = new ArrayList<>();

//    @ManyToOne
}
