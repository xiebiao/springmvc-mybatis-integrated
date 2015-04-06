package com.google.guava.base.test;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class StringsTest {
    @Test
    public void test_padEnd(){
        String text= "Name is Xiaog";
        System.out.println(Strings.padEnd(text, 40, 's'));
        System.out.println(Strings.padStart(text, 16, '!'));
    }
}
