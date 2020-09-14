package com.gd.lambda;

import com.gd.lambda.bean.Sku;
import com.gd.lambda.constant.SkuCategoryEnum;
import com.gd.lambda.predicate.SkuPredicate;
import com.gd.lambda.predicate.impl.SkuPredicateCategroyImpl;
import com.gd.lambda.service.CarService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarTest {

    List<Sku> carSkuList;

    /**
     * 根据插入的断言接口实例，过滤商品
     * <p>
     * for version 3.0.0
     *
     * @param carSkuList
     */
    @Test
    public static void filterSkusByPredicate(List<Sku> carSkuList) {
        // 通过谓语判断条件进行过滤
        List<Sku> skus = CarService.filterSkusByPredicate(carSkuList, new SkuPredicateCategroyImpl());
        printSkus(skus);
    }

    /**
     * 打印Skus
     *
     * @param skus
     */
    private static void printSkus(List<Sku> skus) {
        for (Sku sku : skus) {
            System.out.println(sku.toString());
        }
    }

    @Before
    public void init() {
        carSkuList = CarService.getCarSkuList();
    }

    /**
     * 过滤出电子产品
     * <p>
     * for version 1.0.0
     */
    @Test
    public void filterElectronics() {
        List<Sku> electronicsSkus = CarService.filterElectronicsSkus(carSkuList);
        printSkus(electronicsSkus);
    }

    /**
     * 根据传入的品类进行过滤
     * <p>
     * for version 2.0.0
     */
    @Test
    public void filterSkusByCategory() {
        List<Sku> skus = CarService.filterSkusByCategory(carSkuList, SkuCategoryEnum.BOOKS);
        printSkus(skus);
    }

    /**
     * 根据断言匿名实现类完成过滤
     * <p>
     * for version 3.1.0
     */
    @Test
    public void filterSkusByPredcateAnonymousImpl() {
        // Anonymous new SkuPredicate() can be replaced with lambda
        List<Sku> skus = CarService.filterSkusByPredicate(carSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCateGory());
            }
        });
        printSkus(skus);
    }

    /**
     * 根据断言lambda完成过滤
     * <p>
     * for version 3.2.0
     */
    @Test
    public void filterSkusByPredcateLambda() {
        List<Sku> skus = CarService.filterSkusByPredicate(carSkuList,
                sku -> SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCateGory()));
        printSkus(skus);
    }


}
