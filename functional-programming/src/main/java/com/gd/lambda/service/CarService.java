package com.gd.lambda.service;

import com.gd.lambda.bean.Sku;
import com.gd.lambda.constant.SkuCategoryEnum;
import com.gd.lambda.predicate.SkuPredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务类
 *
 * @author chenpengfei
 */
public class CarService {

    private static List<Sku> carSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(100001, "无人机",
                    29999.00, 1, 29999.00,
                    SkuCategoryEnum.ELECTRONICS));

            add(new Sku(100002, "手机",
                    6999.00, 1, 6999.00,
                    SkuCategoryEnum.ELECTRONICS));

            add(new Sku(200001, "衣服",
                    100.00, 3, 300.00,
                    SkuCategoryEnum.CLOTHING));

            add(new Sku(300001, "羽毛球",
                    319.00, 1, 319.00,
                    SkuCategoryEnum.SPORTS));

            add(new Sku(400001, "Java入门",
                    99.00, 1, 99.00,
                    SkuCategoryEnum.BOOKS));

            add(new Sku(400002, "Java进阶",
                    199.00, 1, 199.00,
                    SkuCategoryEnum.BOOKS));
        }
    };

    /**
     * 获取购物车商品列表
     *
     * @return 购物车商品列表
     * @version 1.0 指定类型
     */
    public static List<Sku> getCarSkuList() {
        return carSkuList;
    }

    public static List<Sku> filterElectronicsSkus(List<Sku> carSkuList) {
        List<Sku> res = new ArrayList<>();
        for (Sku sku : carSkuList) {
            if (sku.getSkuCateGory().equals(SkuCategoryEnum.ELECTRONICS)) {
                res.add(sku);
            }
        }
        return res;
    }

    /**
     * 根据传入商品的类型参数，找出购物车中指定类型的商品列表
     *
     * @param carSkuList
     * @return
     * @version 2.0  参数化类型
     */
    public static List<Sku> filterSkusByCategory(List<Sku> carSkuList, SkuCategoryEnum skuCategoryEnum) {
        List<Sku> res = new ArrayList<>();
        for (Sku sku : carSkuList) {
            if (sku.getSkuCateGory().equals(skuCategoryEnum)) {
                res.add(sku);
            }
        }
        return res;
    }

    /**
     * 根据传入的断言过滤商品列表
     *
     * @param carSkuList
     * @param skuCategoryEnum
     * @return
     * @version 3.0 过滤断言
     */
    public static List<Sku> filterSkusByPredicate(List<Sku> carSkuList, SkuPredicate skuCategoryEnum) {
        List<Sku> res = new ArrayList<>();
        for (Sku sku : carSkuList) {
            if (skuCategoryEnum.test(sku)) {
                res.add(sku);
            }
        }
        return res;

    }
}
