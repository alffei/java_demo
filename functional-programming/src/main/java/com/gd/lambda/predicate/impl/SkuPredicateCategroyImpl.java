package com.gd.lambda.predicate.impl;

import com.gd.lambda.bean.Sku;
import com.gd.lambda.constant.SkuCategoryEnum;
import com.gd.lambda.predicate.SkuPredicate;

/**
 * 判断谓语实现类
 *
 * @author chenpengfei
 */
public class SkuPredicateCategroyImpl implements SkuPredicate {
    /**
     * 传入SKU是否满足条件
     *
     * @param sku
     * @return
     */
    @Override
    public boolean test(Sku sku) {
        return SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCateGory());
    }
}
