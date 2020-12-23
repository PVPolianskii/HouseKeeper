package dev.pvpolianskii.housekeeper.repository;

import dev.pvpolianskii.housekeeper.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository <Goods, Long> {

    Optional<Goods> findGoodsByName (String name);

    }
