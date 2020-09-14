package com.gd.lambda.predicate;

import com.gd.lambda.bean.Sku;

/**
 * @author chenpengfei
 */
public interface SkuPredicate {

    /**
     * 传入SKU是否满足条件
     *
     * @param sku
     * @return
     */
    public boolean test(Sku sku);
}
