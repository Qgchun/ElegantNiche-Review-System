package com.Qgchun.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shkstart
 * @create 2022-11-02 20:29
 */
@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient redissonClient(){
     //配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.226.130:6379").setPassword("root");
        //创建RedissionClient对象
        return Redisson.create(config);
    }
}
