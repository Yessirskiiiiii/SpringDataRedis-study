package com.threewater.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 虞赟淼
 * @Date: 2022/03/08/19:16
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private Integer age;

}
