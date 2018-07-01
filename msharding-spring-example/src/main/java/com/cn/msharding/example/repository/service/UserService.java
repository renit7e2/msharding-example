package com.cn.msharding.example.repository.service;

import com.cn.msharding.example.repository.po.UserPO;

import java.util.List;

/**
 * Created by kaizen on 2018/6/30.
 */
public interface UserService {
    int save(UserPO userPO);

    long batchSave(List<UserPO> userPOs);

    UserPO queryByUid(long uid);

    int updateNameByUid(long uid, String name);

    int deleteByUid(long uid);
}
