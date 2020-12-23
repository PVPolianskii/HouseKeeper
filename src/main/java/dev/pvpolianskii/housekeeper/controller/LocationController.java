package dev.pvpolianskii.housekeeper.controller;

import dev.pvpolianskii.housekeeper.model.Location;
import dev.pvpolianskii.housekeeper.repository.LocationRepository;
import dev.pvpolianskii.housekeeper.request.LocationRequest;
import dev.pvpolianskii.housekeeper.response.LocationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationRepository locationRepository;

    @PostMapping("/locations")
    public void addLocation(@RequestBody LocationRequest locationRequest) {
        final Location location = new Location();
        location.locationSet(locationRequest);
        locationRepository.save(location);
    }

    @GetMapping("/locations/{id}")
    public LocationResponse locationFindById(@PathVariable Long id) {
        final Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        final LocationResponse locationResponse = LocationResponse.fromEntity(location);
        return locationResponse;
    }

    @GetMapping("/locations")
    public LocationResponse locationFindByName(@RequestParam String name) {
        final Location location = locationRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        return LocationResponse.fromEntity(location);
    }

    @PatchMapping("/locations/{id}")
    public void updateLocation(@PathVariable Long id, @RequestBody LocationRequest locationRequest) {
        final Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        location.locationSet(locationRequest);
        locationRepository.save(location);
    }

    @DeleteMapping("/locations/{id}")
    public void deleteLocation (@PathVariable Long id) {
        final Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        locationRepository.delete(location);
    }

}
