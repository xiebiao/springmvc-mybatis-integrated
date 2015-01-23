package com.xiebiao.example;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Hamcrest的断言是对junit的补充
 *
 * @author xiebiao
 * @date 1/23/15
 */
public class HamcrestTest {
    @Test public void test1() {
        Assert.assertThat(9, Matchers.is(9));
    }

    @Test public void test2() {
        Assert.assertThat(6, Matchers.greaterThan(7));
    }

}
