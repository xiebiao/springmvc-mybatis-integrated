package com.github.commons;

import redis.clients.jedis.Jedis;

/**
 *
 */
public class SimpleJedis {

  protected static String PMP_CACHE_TEST_KEY_1 = "pmp.cache.test.key1";
  protected static String PMP_CACHE_TEST_KEY_2 = "pmp.cache.test.key2";

  public static void main(String[] args) {

    Jedis jedis = new Jedis("10.28.168.39", 6378);
    // 删数据
    jedis.del(PMP_CACHE_TEST_KEY_1);
    // 存数据
    jedis.set("a".getBytes(), "v".getBytes());
    jedis.set(PMP_CACHE_TEST_KEY_1, "pmp1");
    // 取数据
    String value = jedis.get(PMP_CACHE_TEST_KEY_1);
    System.out.println(value);
  }
}
