package dev.pvpolianskii.housekeeper;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goods")
@Getter
@Setter


public class Goods {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "goods", cascade = CascadeType.PERSIST)
    private List<GoodsInStore> listGoodsInStore = new ArrayList<>();

    @OneToMany(mappedBy = "goods", cascade = CascadeType.PERSIST)
    private List<Price> prices = new ArrayList<>();




}
