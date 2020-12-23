package dev.pvpolianskii.housekeeper.controller;

import dev.pvpolianskii.housekeeper.model.Location;
import dev.pvpolianskii.housekeeper.model.Store;
import dev.pvpolianskii.housekeeper.repository.LocationRepository;
import dev.pvpolianskii.housekeeper.repository.StoreRepository;
import dev.pvpolianskii.housekeeper.request.StoreCreationRequest;
import dev.pvpolianskii.housekeeper.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;

    @PostMapping("/store")
    public void addStore(@RequestBody StoreCreationRequest storeCreationRequest) {

        final Location location = locationRepository.findById(storeCreationRequest.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));

        final Store store = new Store();
        store.setName(storeCreationRequest.getStoreName());
        store.setLocation(location);
        storeRepository.save(store);

    }

    @GetMapping("/store/{id}")
    public StoreResponse findStoreById(@PathVariable Long id) {

        final Store store = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        return StoreResponse.fromEntity(store);
    }

}
