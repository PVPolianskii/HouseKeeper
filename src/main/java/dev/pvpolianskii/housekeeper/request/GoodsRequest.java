package dev.pvpolianskii.housekeeper.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GoodsRequest {

    @JsonProperty(value = "goodsName")
    @NotEmpty
    private String goodsName;

    @JsonProperty(value = "price")
    @NotNull
    @Positive
    private Double price;

    @JsonProperty(value = "quantity")
    @NotNull
    @Positive
    private Integer quantity;

    @JsonProperty(value = "store")
    @NotNull
    @Positive
    private Long storeId;

    @JsonProperty(value = "note")
    private String note;
}
