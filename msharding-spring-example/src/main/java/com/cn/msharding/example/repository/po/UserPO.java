package com.cn.msharding.example.repository.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by kaizen on 2018/6/30.
 */
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class UserPO {
    private long uid;
    private String name;
}
