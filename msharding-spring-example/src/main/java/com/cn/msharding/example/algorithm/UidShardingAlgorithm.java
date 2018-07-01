package com.cn.msharding.example.algorithm;

import com.cn.msharding.core.ShardingParam;
import com.cn.msharding.core.algorithm.ShardingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaizen on 2018/6/30.
 */
public class UidShardingAlgorithm implements ShardingAlgorithm<Long> {
    /**
     * 创建三张字表，根据uid取模参数进行分表，分片参数为空结果落到逻辑表（原表）
     *
     * @param availableTables 可用表
     * @param param           分片参数
     * @return
     */
    @Override
    public List<String> doSharding(List<String> availableTables, ShardingParam<Long> param) {
        List<String> result = new ArrayList<>();
        if (param == null || param.getShardingParam() == null) {
            return availableTables;
        }
        for (String str : availableTables) {
            if (Integer.valueOf(str) == param.getShardingParam() % 3) {
                result.add(str);
            }
        }
        return availableTables;
    }
}
