package dev.pvpolianskii.housekeeper.response;

import dev.pvpolianskii.housekeeper.model.Goods;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GoodsResponse {

    private  String name;
    private  String note;

    public static GoodsResponse fromEntity(Goods goods) {

        GoodsResponse goodsResponse = GoodsResponse.builder()
                .name(goods.getName())
                .note(goods.getNote())
                .build();
        return goodsResponse;

    }

}
