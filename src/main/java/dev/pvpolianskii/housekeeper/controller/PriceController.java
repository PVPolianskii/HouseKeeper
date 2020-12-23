package dev.pvpolianskii.housekeeper.controller;

import dev.pvpolianskii.housekeeper.model.Goods;
import dev.pvpolianskii.housekeeper.model.Price;
import dev.pvpolianskii.housekeeper.repository.GoodsRepository;
import dev.pvpolianskii.housekeeper.repository.PriceRepository;
import dev.pvpolianskii.housekeeper.request.PriceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PriceController {
    final PriceRepository priceRepository;
    final GoodsRepository goodsRepository;

    @PostMapping("/prices")
    public void addPrice(@RequestBody PriceRequest priceRequest) {
        final Price price = new Price();

        Goods goods = goodsRepository.getOne(priceRequest.getGoodsId());
        price.setGoods(goods);
        price.setPrice(priceRequest.getPrice());

        priceRepository.save(price);




    }
}
