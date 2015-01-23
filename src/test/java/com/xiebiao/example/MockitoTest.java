package com.xiebiao.example;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.List;

/**
 * @author xiebiao
 * @date 1/23/15
 */
public class MockitoTest {
    @Test public void test1() {
        //mock接口
        List<String> listData = mock(List.class);
        //mock行为
        when(listData.get(0)).thenReturn("test");
        String result = listData.get(0);
        //验证方法调用(是否调用了get(0))
        verify(listData).get(0);


        //junit测试
        Assert.assertEquals("test", result);
    }
}
