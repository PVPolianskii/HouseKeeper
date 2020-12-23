package dev.pvpolianskii.housekeeper.repository;

import dev.pvpolianskii.housekeeper.model.Goods;
import dev.pvpolianskii.housekeeper.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findAllByGoods(Goods goods);
}
