package dev.pvpolianskii.housekeeper.service;

import dev.pvpolianskii.housekeeper.response.GoodsResponse;
import dev.pvpolianskii.housekeeper.model.Goods;
import dev.pvpolianskii.housekeeper.model.Price;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AveragePrice {

    private GoodsResponse goodsResponse;
    private Double price;

    public static AveragePrice averagePrice(@NonNull List<Price> prices) {

        if (prices.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        Goods firstGoods = prices.get(0).getGoods();


        for (int i = 1; i < prices.size(); i++) {
            if (!firstGoods.equals(prices.get(i).getGoods())) {
                throw new IllegalArgumentException("Goods not equals");
            }
        }


        double count = 0.0;
        for (Price lp : prices) {
            count = count + lp.getPrice();
        }
        double result = count / prices.size();

        AveragePrice averagePrice = new AveragePrice();
        GoodsResponse goodsResponse = GoodsResponse.fromEntity(prices.get(0).getGoods());
        averagePrice.setGoodsResponse(goodsResponse);
        averagePrice.setPrice(result);
        return averagePrice;
    }
}
