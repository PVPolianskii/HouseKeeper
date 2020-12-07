package dev.pvpolianskii.housekeeper;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Getter
@Setter


public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Column(name = "date")
//    @CreationTimestamp
    private LocalDateTime localDateTime;

    @Column(name = "price")
    private Double price;

    @PrePersist
    private void setDate () {
        localDateTime = LocalDateTime.now();
    }


}
