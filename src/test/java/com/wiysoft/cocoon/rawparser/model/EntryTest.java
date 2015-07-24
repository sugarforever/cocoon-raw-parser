package com.wiysoft.cocoon.rawparser.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by weiliyang on 7/24/15.
 */
public class EntryTest {

    @Test
    public void testSetType() {
        String type = "卖盘";
        Entry e = new Entry();
        e.setType(type);
        Assert.assertEquals("s", e.getType());
    }

    @Test
    public void testSetType2() {
        String type = "买盘";
        Entry e = new Entry();
        e.setType(type);
        Assert.assertEquals("b", e.getType());
    }

    @Test
    public void testSetType3() {
        String type = "中性盘";
        Entry e = new Entry();
        e.setType(type);
        Assert.assertEquals("n", e.getType());
    }

    @Test
    public void testSetType4() {
        String type = "打开肌肤的开发基地";
        Entry e = new Entry();
        e.setType(type);
        Assert.assertEquals("-", e.getType());
    }
}
