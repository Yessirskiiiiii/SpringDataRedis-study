package com.threewater;

import com.threewater.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot05RedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
        // 写入一条String数据
        redisTemplate.opsForValue().set("name", "呵呵");
        // 获取String数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    void testSaveUser() {
        // 写入数据
        redisTemplate.opsForValue().set("user:2", new User("周杰伦", 18));
        // 获取数据
        User user = (User) redisTemplate.opsForValue().get("user:2");
        System.out.println(user);
    }

}
