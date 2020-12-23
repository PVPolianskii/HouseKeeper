package dev.pvpolianskii.housekeeper;

import dev.pvpolianskii.housekeeper.model.Goods;
import dev.pvpolianskii.housekeeper.model.Price;
import dev.pvpolianskii.housekeeper.service.AveragePrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class AveragePriceTest {


    @Test
    void averagePriceAtNormalCase() {
        Goods goods1 = Goods.builder().name("goodsik").note("notik").build();

        List<Price> testList = Stream.of(
                Price.builder().goods(goods1).price(10.0).build(),
                Price.builder().goods(goods1).price(20.0).build()
        )
                .collect(Collectors.toList());


        AveragePrice actualAveragePrice = AveragePrice.averagePrice(testList);
        Assertions.assertEquals(15.0, actualAveragePrice.getPrice());
        Assertions.assertEquals("goodsik", actualAveragePrice.getGoodsResponse().getName());
        Assertions.assertEquals("notik", actualAveragePrice.getGoodsResponse().getNote());
    }

    @Test
    void averagePriceAtEmptyPriceList() {
        List<Price> testList = Collections.emptyList();

        Assertions.assertThrows(IllegalArgumentException.class, () -> AveragePrice.averagePrice(testList));

    }


    @Test
    void averagePriceAtDifferentGoods() {
        Goods goods1 = Goods.builder().name("goodsik").note("notik").build();
        Goods goods2 = Goods.builder().name("goods2").note("note2").build();

        List<Price> testList = Stream.of(
                Price.builder().goods(goods1).price(10.0).build(),
                Price.builder().goods(goods2).price(20.0).build()
        )
                .collect(Collectors.toList());

        Assertions.assertThrows(IllegalArgumentException.class, ()-> AveragePrice.averagePrice(testList));


    }
}