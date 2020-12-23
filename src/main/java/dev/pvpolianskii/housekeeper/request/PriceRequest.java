package dev.pvpolianskii.housekeeper.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PriceRequest {

    @JsonProperty(value = "goods_id")
    private Long goodsId;

    @JsonProperty(value = "price")
    private Double price;
}
