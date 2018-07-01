package com.cn.msharding.example.repository.dao;

import com.cn.msharding.core.ShardingParam;
import com.cn.msharding.core.annotion.TableChoose;
import com.cn.msharding.core.strategy.LastTableChooseStrategy;
import com.cn.msharding.example.repository.po.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kaizen on 2018/6/30.
 */
public interface UserDao {
    @TableChoose(LastTableChooseStrategy.class)
    int insert(@Param("sharding") ShardingParam sharding, @Param("item") UserPO userPO);

    @TableChoose(LastTableChooseStrategy.class)
    long batchInsert(@Param("sharding") ShardingParam sharding, @Param("list") List<UserPO> userPOs);

    UserPO queryByUid(@Param("sharding") ShardingParam sharding, @Param("uid") long uid);

    int updateNameByUid(@Param("sharding") ShardingParam sharding, @Param("uid") long uid, @Param("name") String name);

    int deleteByUid(@Param("sharding") ShardingParam sharding, @Param("uid") long uid);
}
