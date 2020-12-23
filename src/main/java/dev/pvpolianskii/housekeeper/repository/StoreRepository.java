package dev.pvpolianskii.housekeeper.repository;

import dev.pvpolianskii.housekeeper.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{
}
