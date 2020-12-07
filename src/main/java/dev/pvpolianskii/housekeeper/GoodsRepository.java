package dev.pvpolianskii.housekeeper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository <Goods, Long> {

    }
