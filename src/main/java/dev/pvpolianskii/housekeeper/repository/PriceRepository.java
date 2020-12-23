package dev.pvpolianskii.housekeeper.repository;

import dev.pvpolianskii.housekeeper.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}
