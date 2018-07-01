package com.cn.msharding.example.repository.service;

import com.cn.msharding.BaseJunit4Test;
import com.cn.msharding.example.repository.po.UserPO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaizen on 2018/6/30.
 */
public class UserServiceTest extends BaseJunit4Test {
    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser() {
        long uid = 122;
        String userName = "tom";
        System.err.println("save tom》》》》》》" + userService.save(new UserPO(uid, userName)));
        System.err.println("#########################");
    }

    @Test
    public void testBatchSaveUser() {
        long uid1 = 211;
        String name1 = "tom1";
        long uid2 = 212;
        String name2 = "tom2";
        List<UserPO> userPOs = new ArrayList<>();
        userPOs.add(new UserPO(uid1, name1));
        userPOs.add(new UserPO(uid2, name2));

        System.err.println("batchSave 》》》》》》" + userService.batchSave(userPOs));
        System.err.println("#########################");
    }

    @Test
    public void testUpdateUserName() {
        long uid = 122;
        String changeName = "jerry";
        System.err.println("update 》》》》》》" + userService.updateNameByUid(uid, changeName));
        System.err.println("#########################");
    }

    @Test
    public void testQueryByUid() {
        long uid = 122;
         System.err.println("query 》》》》》》" + userService.queryByUid(uid));
        System.err.println("#########################");
    }

    @Test
    public void testDeleteUser() {
        long uid = 122;
        System.err.println("delete 》》》》》》" + userService.deleteByUid(uid));
        System.err.println("#########################");
    }
}
