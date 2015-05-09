package com.google.guava.base.test;

import com.google.common.base.Charsets;
import org.junit.Test;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class CharsetsTest {
    @Test
    public void test_c(){
        System.out.println(Charsets.ISO_8859_1.canEncode());

    }
}
