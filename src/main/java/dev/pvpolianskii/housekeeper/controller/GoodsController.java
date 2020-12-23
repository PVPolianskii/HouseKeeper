package dev.pvpolianskii.housekeeper.controller;


import dev.pvpolianskii.housekeeper.model.Goods;
import dev.pvpolianskii.housekeeper.model.GoodsInStore;
import dev.pvpolianskii.housekeeper.model.Price;
import dev.pvpolianskii.housekeeper.model.Store;
import dev.pvpolianskii.housekeeper.repository.GoodsRepository;
import dev.pvpolianskii.housekeeper.repository.PriceRepository;
import dev.pvpolianskii.housekeeper.repository.StoreRepository;
import dev.pvpolianskii.housekeeper.request.GoodsRequest;
import dev.pvpolianskii.housekeeper.response.GoodsResponse;
import dev.pvpolianskii.housekeeper.service.AveragePrice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsRepository goodsRepository;
    private final StoreRepository storeRepository;
    private final PriceRepository priceRepository;



    @PostMapping("/goods")
    public void addGoods(@RequestBody GoodsRequest goodsRequest) {

        final GoodsInStore goodsInStore = new GoodsInStore();
        goodsInStore.setQuantity(goodsRequest.getQuantity());

        final Store store = storeRepository.findById(goodsRequest.getStoreId())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        final Goods goods = new Goods();
        goods.setName(goodsRequest.getGoodsName());
        goods.setNote(goodsRequest.getNote());

        goodsInStore.setStore(store);
        store.getListGoodsInStore().add(goodsInStore);
        goods.getListGoodsInStore().add(goodsInStore);
        goodsInStore.setGoods(goods);

        final Price price = new Price();
        price.setPrice(goodsRequest.getPrice());
        goods.getPrices().add(price);
        price.setGoods(goods);

        goodsRepository.save(goods);
    }

    @GetMapping("/goods/{id}")
    public GoodsResponse findGoodsById(@PathVariable Long id) {

        final Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goods not found"));
        return GoodsResponse.fromEntity(goods);

    }

    @GetMapping("/goods")
    public GoodsResponse findGoodsByName(@RequestParam String name) {

        final Goods goods = goodsRepository.findGoodsByName(name)
                .orElseThrow(() -> new RuntimeException("Goods not found"));
        return GoodsResponse.fromEntity(goods);
    }


    @PatchMapping("goods/{id}")
    public void updateGoods(@PathVariable Long id, @RequestBody GoodsRequest goodsRequest) {

        final Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goods not found"));

        goods.setName(goodsRequest.getGoodsName());
        goods.setNote(goodsRequest.getNote());

        goodsRepository.save(goods);

    }

    @DeleteMapping("/goods/{id}")
    public void deleteGoods(@PathVariable Long id) {

        final Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goods not Found"));
        goodsRepository.delete(goods);
    }

    @GetMapping("goods/{id}/average_price")
    public AveragePrice averagePrice(@PathVariable Long id) {

        final Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goods not found"));

        final List<Price> prices = goods.getPrices();

        return AveragePrice.averagePrice(prices);

    }

}



