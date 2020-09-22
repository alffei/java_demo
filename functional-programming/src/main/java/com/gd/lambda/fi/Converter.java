package com.gd.lambda.fi;

/**
 * @author chenpengfei
 */
@FunctionalInterface
public interface Converter<F, T> {
    /**
     * 转换函数
     *
     * @param form
     * @return
     */
    T convert(F form);
}
