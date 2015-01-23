package com.github.commons;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Redis目前只能做主备,分区分片只能通过客户端实现
 */
public class PooledJedis extends SimpleJedis {

    private static ShardedJedisPool pool;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        if (bundle == null) {
            throw new IllegalArgumentException("[redis.properties] is not found!");
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
        config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
        config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
        config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));

        List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
        list.add(
            new JedisShardInfo(bundle.getString("redis1.ip"), bundle.getString("redis1.port")));
        list.add(
            new JedisShardInfo(bundle.getString("redis2.ip"), bundle.getString("redis2.port")));
        pool = new ShardedJedisPool(config, list);

    }

    public PooledJedis() {

    }

    public ShardedJedis getShardedJedis() {
        return pool.getResource();
    }

    public static void main(String[] args) {
        PooledJedis pooled = new PooledJedis();
        ShardedJedis jedis = pooled.getShardedJedis();
        // 删数据
        jedis.del(PMP_CACHE_TEST_KEY_2);
        // 存数据
        jedis.set(PMP_CACHE_TEST_KEY_2, "pmp2");
        // 取数据
        String value = jedis.get(PMP_CACHE_TEST_KEY_2);
        System.out.println(value);
    }
}
