package com.cn.msharding.example;


import com.cn.msharding.core.ShardingContext;
import com.cn.msharding.core.ShardingThreadPoolManager;
import com.cn.msharding.core.constant.ShardingConstant;
import com.cn.msharding.core.filter.ShardingFilterManager;

import java.util.Properties;

/**
 * <pre>Created by Kaizen Xue on 2018/6/30</pre>
 */
public class ShardingConfig {

    public void init() {
        //初始化filter
        ShardingFilterManager.getInstance().init(ShardingContext.getInstance().getBeanFactory());
        //初始化分片数据库操作线程池
        Properties properties = new Properties();
        properties.setProperty(ShardingConstant.SHARDING_CORE_THREAD, String.valueOf(ShardingConstant.DEFAULT_SHARDING_CORE_THREAD_NUM));
        properties.setProperty(ShardingConstant.SHARDING_MAX_THREAD, String.valueOf(ShardingConstant.DEFAULT_SHARDING_MAX_THREAD_NUM));
        properties.setProperty(ShardingConstant.SHARDING_QUEUE_LENGTH, String.valueOf(ShardingConstant.DEFALUT_SHARDING_QUEUE_LENGTH_NUM));
        ShardingThreadPoolManager.getInstance().init(properties);
    }

    public void destroy() {
        //关闭分片执行连接线程池
        ShardingThreadPoolManager.getInstance().shutdown();
        //destroy filter
        ShardingFilterManager.getInstance().destroy();
        //关闭配置刷新线程池
        ShardingContext.getInstance().shutDown();
    }
}
