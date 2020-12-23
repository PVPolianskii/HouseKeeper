package dev.pvpolianskii.housekeeper.response;


import dev.pvpolianskii.housekeeper.model.Store;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class StoreResponse {

    private Long id;
    private String name;
    private LocationResponse location;

    public static StoreResponse fromEntity(Store store) {
        StoreResponse storeResponse = StoreResponse.builder()
                .id(store.getId())
                .name(store.getName())
                .location(LocationResponse.fromEntity(store.getLocation()))
                .build();
        return storeResponse;
    }
}
