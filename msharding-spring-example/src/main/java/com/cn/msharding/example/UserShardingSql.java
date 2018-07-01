package com.cn.msharding.example;

import com.cn.msharding.jdbc.router.service.ShardingRouterService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by kaizen on 2018/6/30.
 */
@Component
public class UserShardingSql implements InitializingBean {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ShardingRouterService shardingRouterService;

    private void initShardingRouter() {
        String deleteSql = "delete from t_sharding_router";
        String shardingSql = "INSERT INTO `t_sharding_router` VALUES (1, 't_user', 'uidShardingAlgorithm', '', '[0-2]', 1, 1,now(), now())";
        jdbcTemplate.execute(deleteSql);
        jdbcTemplate.execute(shardingSql);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        shardingRouterService.init();
        initShardingRouter();
        createUserTable();
    }

    private void createUserTable() {
        String logicTable = "CREATE TABLE  IF NOT EXISTS `t_user` (\n" +
                "\t`uid` INT NOT NULL,\n" +
                "\t`name` VARCHAR(50) NOT NULL\n" +
                ")\n" +
                ";";
        String table1 = "CREATE TABLE IF NOT EXISTS `t_user_1` (\n" +
                "\t`uid` INT NOT NULL,\n" +
                "\t`name` VARCHAR(50) NOT NULL\n" +
                ")\n" +
                ";";
        String table2 = "CREATE TABLE IF NOT EXISTS `t_user_2` (\n" +
                "\t`uid` INT NOT NULL,\n" +
                "\t`name` VARCHAR(50) NOT NULL\n" +
                ")\n" +
                ";";
        String table3 = "CREATE TABLE IF NOT EXISTS `t_user_0` (\n" +
                "\t`uid` INT NOT NULL,\n" +
                "\t`name` VARCHAR(50) NOT NULL\n" +
                ")\n" +
                ";";
        jdbcTemplate.execute(logicTable);
        jdbcTemplate.execute(table1);
        jdbcTemplate.execute(table2);
        jdbcTemplate.execute(table3);
    }
}
