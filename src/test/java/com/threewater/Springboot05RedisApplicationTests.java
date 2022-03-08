package com.threewater;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot05RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        // 写入一条String数据
        redisTemplate.opsForValue().set("name", "zjl");
        // 获取String数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

}
