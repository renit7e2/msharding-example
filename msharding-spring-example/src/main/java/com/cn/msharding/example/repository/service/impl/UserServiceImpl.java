package com.cn.msharding.example.repository.service.impl;

import com.cn.msharding.core.ShardingParam;
import com.cn.msharding.example.constant.MShardingConstant;
import com.cn.msharding.example.repository.dao.UserDao;
import com.cn.msharding.example.repository.po.UserPO;
import com.cn.msharding.example.repository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kaizen on 2018/6/30.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int save(UserPO userPO) {
        return userDao.insert(new ShardingParam().buildLogicName(MShardingConstant.USER_TABLE).buildShardingParam(userPO.getUid()), userPO);
    }

    @Override
    public long batchSave(List<UserPO> userPOs) {
        return userDao.batchInsert(new ShardingParam().buildLogicName(MShardingConstant.USER_TABLE).buildShardingParam(null), userPOs);
    }

    @Override
    public UserPO queryByUid(long uid) {
        return userDao.queryByUid(new ShardingParam().buildLogicName(MShardingConstant.USER_TABLE).buildShardingParam(uid), uid);
    }

    @Override
    public int updateNameByUid(long uid, String name) {
        return userDao.updateNameByUid(new ShardingParam().buildLogicName(MShardingConstant.USER_TABLE).buildShardingParam(uid), uid, name);
    }

    @Override
    public int deleteByUid(long uid) {
        return userDao.deleteByUid(new ShardingParam().buildLogicName(MShardingConstant.USER_TABLE).buildShardingParam(uid), uid);
    }
}
