package dev.pvpolianskii.housekeeper.model;

import dev.pvpolianskii.housekeeper.model.Goods;
import dev.pvpolianskii.housekeeper.model.Store;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "goods_in_store")
@Getter
@Setter
public class GoodsInStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn (name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Column(name = "quantity")
    private Integer quantity;
}
