package com.threewater;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.threewater.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 虞赟淼
 * @Date: 2022/03/09/9:24
 * @Description:
 */
@SpringBootTest
public class RedisStringTests {

    // StringRedisTemplate类，它的key和value的序列化方式默认就是String方式
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        // 写入一条String数据
        stringRedisTemplate.opsForValue().set("name", "哈哈");
        // 获取String数据
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    // ObjectMapper为SpringMVC默认提供的Json处理工具
    private static final ObjectMapper mapper = new ObjectMapper();

    // 写入对象(多了手动处理的过程)
    @Test
    void testSaveUser() throws JsonProcessingException {
        // 创建对象
        User user = new User("嚯嚯", 18);
        // 手动序列化
        String json = mapper.writeValueAsString(user);
        // 写入数据
        stringRedisTemplate.opsForValue().set("user:1", json);

        // 获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:1");
        // 手动反序列化
        User user1 = mapper.readValue(jsonUser, User.class);
        System.out.println(user1);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:1", "name", "周杰伦");
        stringRedisTemplate.opsForHash().put("user:1", "age", "18");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:4");
        System.out.println(entries);
    }

}
