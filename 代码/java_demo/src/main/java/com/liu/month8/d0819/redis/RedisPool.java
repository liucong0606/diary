package com.liu.month8.d0819.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author liucong
 * @ClassName: RedisPool
 * @Description:
 * @date: 2020/8/19 10:42
 */
public class RedisPool {
    private static JedisPool pool;  // jedis 连接池
    private static int maxTotal = 20;   // 最大连接数
    private static int maxIdle = 5;     // 最大空闲连接数
    private static int minIdle = 5;     // 最小空闲连接数
    private static boolean testOnBorrow = true; // 在取连接时测试连接的可用性
    private static boolean testOnReturn = false;    // 在还连接时不测试连接的可用性

    static {
        initPool();
    }

    /**
     * @Description: 初始化 jedis 连接池
     * @auther: liucong
     * @date: 2020/8/19 10:48
     * @return:
     */
    private static void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        config.setBlockWhenExhausted(true);
        pool = new JedisPool(config, "127.0.0.1", 6379, 5000);
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void close(Jedis jedis) {
        if (jedis != null)
            jedis.close();
    }
}