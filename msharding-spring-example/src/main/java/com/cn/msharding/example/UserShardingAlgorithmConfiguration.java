package com.cn.msharding.example;

import com.cn.msharding.core.algorithm.ShardingAlgorithm;
import com.cn.msharding.core.strategy.ShardingAlgorithmConfiguration;
import com.cn.msharding.example.algorithm.UidShardingAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>Created by Kaizen Xue on 2018/6/30.</pre>
 */
public class UserShardingAlgorithmConfiguration implements ShardingAlgorithmConfiguration {
    @Override
    public Map<String, ShardingAlgorithm> registerAlgorithm() {
        Map<String, ShardingAlgorithm> shardingConfigs = new HashMap<>();
        shardingConfigs.put("uidShardingAlgorithm", new UidShardingAlgorithm());
        return shardingConfigs;
    }
}
