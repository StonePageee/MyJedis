package com.lts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Set;

@SpringBootTest
class JedisApplicationTests {

    @Test
    void testRedis() {
//        获取连接
        Jedis jedis = new Jedis("192.168.254.135",6379);

//        执行具体操作
        jedis.auth("redis");
        jedis.set("username","xiaoming");

        jedis.hset("myhash","gender","男");
        System.out.println(jedis.hget("myhash", "gender"));

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
//        关闭连接123
        jedis.close();
    }

}
