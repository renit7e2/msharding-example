package com.cn.msharding.jdbc.router.service;

import com.cn.msharding.jdbc.router.ShardingRouter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by kaizen on 2018/6/30.
 */
public class ShardingRouterServiceTemplateTest {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IShardingRouterService routerService = applicationContext.getBean(IShardingRouterService.class);
        List<ShardingRouter> shardingRouters = routerService.listAllEnableRouter();
        System.err.println("listAll   》》》》》》" + shardingRouters);
        System.err.println("#########################");
        String tableName = "t_user";
        System.err.println("listByName 》》》》》》" + routerService.listRouterStrategy(tableName));
        System.err.println("#########################");
        System.err.println("listTables 》》》》》》" + routerService.listRouterTable());
    }
}
