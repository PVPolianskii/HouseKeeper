package dev.pvpolianskii.housekeeper;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsRepository goodsRepository;
    private final StoreRepository storeRepository;

    @PostMapping("/goods")
    public void addGoods (@RequestBody GoodsCreationRequest goodsCreationRequest) {

        final GoodsInStore goodsInStore = new GoodsInStore();
        goodsInStore.setQuantity(goodsCreationRequest.getQuantity());

        final Store store = storeRepository.findById(goodsCreationRequest.getStoreId())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        final Goods goods = new Goods();
        goods.setName(goodsCreationRequest.getGoodsName());
        goods.setNote(goodsCreationRequest.getNote());

        goodsInStore.setStore(store);
        store.getListGoodsInStore().add(goodsInStore);
        goods.getListGoodsInStore().add(goodsInStore);
        goodsInStore.setGoods(goods);

        final Price price = new Price();
        price.setPrice(goodsCreationRequest.getPrice()); //ToDo Создать объект класса Price и запихнуть в список Price в Goods
        goods.getPrices().add(price);
        price.setGoods(goods);

        //ToDo Проверить POST запросом работу программы и создать storage

        goodsRepository.save(goods);


    }
}
