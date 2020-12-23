package dev.pvpolianskii.housekeeper.controller;

import dev.pvpolianskii.housekeeper.model.Location;
import dev.pvpolianskii.housekeeper.model.Store;
import dev.pvpolianskii.housekeeper.repository.LocationRepository;
import dev.pvpolianskii.housekeeper.repository.StoreRepository;
import dev.pvpolianskii.housekeeper.request.LocationRequest;
import dev.pvpolianskii.housekeeper.request.StoreRequest;
import dev.pvpolianskii.housekeeper.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;

    @PostMapping("/store")
    public void addStore(@RequestBody StoreRequest storeRequest) {

        final Location location = locationRepository.findById(storeRequest.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));

        final Store store = new Store();
        store.setName(storeRequest.getStoreName());
        store.setLocation(location);
        storeRepository.save(store);

    }

    @GetMapping("/store/{id}")
    public StoreResponse findStoreById(@PathVariable Long id) {

        final Store store = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        return StoreResponse.fromEntity(store);
    }

    @PatchMapping("/store/{id}")
    public void updateStore(@PathVariable Long id, @RequestBody StoreRequest storeRequest) {
        final Store store  = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        store.setName(storeRequest.getStoreName());
        storeRepository.save(store);
    }

    @DeleteMapping("/store/{id}")
    public void deleteStore (@PathVariable Long id) {
        final Store store = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        storeRepository.delete(store);
    }
}
