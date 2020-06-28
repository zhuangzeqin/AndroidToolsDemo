package com.eeepay.zzq.androidtoolsdemo.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/*
 * 描述：list 集合分组 工具类 按照某个字段（依据一定条件）进行分组
 * 作者：zhuangzeqin
 * 时间: 2020/6/16-15:51
 * 邮箱：zzq@eeepay.cn
 * 备注: 快展钱二期代码优化；前期工期比较赶； 好多东西没有考虑周全； 现在有点时间进行优化
 */
public final class ListGroupByUtils {
    /**
     * List分组
     *
     * @param <K> 返回分组Key
     * @param <V> 分组行
     */
    public interface GroupBy<K, V> {
        K groupBy(V row);
    }
    /**
     * list 集合分组
     *
     * @param list    待分组集合
     * @param groupBy 分组Key算法
     * @param <K>     分组Key类型
     * @param <V>     行数据类型
     * @return 分组后的Map集合
     */
    public static <K, V> LinkedHashMap<K, List<V>> groupBy(List<V> list, GroupBy<K, V> groupBy) {
        return groupBy((Collection<V>) list, groupBy);
    }

    /**
     * list 集合分组
     *
     * @param list    待分组集合
     * @param groupBy 分组Key算法
     * @param <K>     分组Key类型
     * @param <V>     行数据类型
     * @return 分组后的Map集合
     */
    public static <K, V> LinkedHashMap<K, List<V>> groupBy(Collection<V> list, GroupBy<K, V> groupBy) {
        LinkedHashMap<K, List<V>> resultMap = new LinkedHashMap<K, List<V>>();
        for (V e : list) {
            K k = groupBy.groupBy(e);
            if (resultMap.containsKey(k)) {
                resultMap.get(k).add(e);
            } else {
                List<V> tmp = new ArrayList<>();
                tmp.add(e);
                resultMap.put(k, tmp);
            }
        }
        return resultMap;
    }
}
