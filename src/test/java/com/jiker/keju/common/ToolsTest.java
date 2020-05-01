package com.jiker.keju.common;

import org.junit.Assert;
import org.junit.Test;

public class ToolsTest {
    private Tools tools = new Tools();

    @Test
    public void fileReader() throws Exception {
        Assert.assertNotNull(tools.fileReader("src/main/resources/testData.txt"));
    }

    @Test
    public void stingToStringArray() throws Exception {
        Assert.assertEquals(tools.stingToStringArray("1公里,等待0分钟\\n" +
                "3公里,等待0分钟\\n" +
                "10公里,等待0分钟\\n" +
                "2公里,等待3分钟"),
                new String[]{"1公里,等待0分钟","3公里,等待0分钟","10公里,等待0分钟","2公里,等待3分钟"});
    }
}