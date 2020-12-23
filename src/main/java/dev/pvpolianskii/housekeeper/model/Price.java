package dev.pvpolianskii.housekeeper.model;

import dev.pvpolianskii.housekeeper.model.Goods;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Column(name = "date")
    private LocalDateTime localDateTime;

    @Column(name = "price")
    private Double price;

    @PrePersist
    private void setDate () {
        localDateTime = LocalDateTime.now();
    }


}
