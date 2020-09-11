package com.liu.month8.d0819.redis;

/**
 * @author liucong
 * @ClassName: DistributedLockUtil
 * @Description:
 * @date: 2020/8/19 11:27
 */
public class DistributedLockUtil {
    private DistributedLockUtil() {}

    public static boolean lock(String lockName) {
        System.out.println(Thread.currentThread() + "开始尝试加锁！");
        Long result = RedisPoolUtils.setnx(lockName, String.valueOf(System.currentTimeMillis() + 5000));
        if (result != null && result.intValue() == 1) {
            System.out.println(Thread.currentThread() + "加锁成功！");
            RedisPoolUtils.expire(lockName, 5);
            System.out.println(Thread.currentThread() + "执行业务逻辑！");
            RedisPoolUtils.del(lockName);
            return true;
        } else {
            String lockValueA = RedisPoolUtils.get(lockName);
            if (lockValueA != null && Long.parseLong(lockValueA) >= System.currentTimeMillis()) {
                String lockValueB = RedisPoolUtils.getSet(lockName, String.valueOf(System.currentTimeMillis() + 5000));
                if (lockValueB == null || lockValueB.equals(lockValueA)) {
                    System.out.println(Thread.currentThread() + "加锁成功！");
                    RedisPoolUtils.expire(lockName, 5);
                    System.out.println(Thread.currentThread() + "执行业务逻辑！");
                    RedisPoolUtils.del(lockName);
                    return true;
                }
            }
        }
        return false;
    }
}
