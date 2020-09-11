package com.liu.month8.d0819.redis;

import redis.clients.jedis.Jedis;

/**
 * @author liucong
 * @ClassName: RedisPoolUtils
 * @Description:
 * @date: 2020/8/19 10:54
 */
public class RedisPoolUtils {
    private RedisPoolUtils() {}

    private static RedisPool redisPool;

    public static String get(String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    public static Long setnx(String key, String value) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.setnx(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    public static String getSet(String key, String value) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.getSet(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    public static Long expire(String key, int seconds) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    public static Long del(String key) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }
}














