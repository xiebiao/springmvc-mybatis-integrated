package com.google.guava.base.test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author bjxieb
 * @date 5/9/15
 */
public class BiMapTest {
    public void test_(){
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        biMap.put("2","Harry");
    }
}
