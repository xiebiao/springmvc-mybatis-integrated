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
        System.out.println(Strings.repeat("**",10));

        System.out.println(Strings.commonSuffix("a1.xxx.jpg", "a2.TTT.jpg"));
        System.out.println(Strings.commonPrefix("a1.xxx","a2.TTT"));
        System.out.println(Strings.padEnd(text, 40, 's'));
        System.out.println(Strings.padStart(text, 16, '!'));
    }
}
