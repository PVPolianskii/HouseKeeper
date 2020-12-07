package dev.pvpolianskii.housekeeper;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;

    @PostMapping("/store")
    public void addStore (@RequestBody StoreCreationRequest storeCreationRequest) {

        final Location location = locationRepository.findById(storeCreationRequest.getLocationId())
                .orElseThrow(()-> new RuntimeException("Location not found"));

        final Store store = new Store();
        store.setName(storeCreationRequest.getStoreName());
//        store.setLocationId();

    }

}
