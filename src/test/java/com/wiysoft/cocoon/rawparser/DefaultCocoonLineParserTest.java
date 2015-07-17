package com.wiysoft.cocoon.rawparser;

import com.wiysoft.cocoon.rawparser.model.Entry;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by weiliyang on 6/30/15.
 */

public class DefaultCocoonLineParserTest {

    private CocoonLineParser cocoonLineParser;

    @Before
    public void setup() {
        this.cocoonLineParser = new DefaultCocoonLineParser();
    }

    @Test
    public void testParseHeaderLine() {
        String line = "成交时间\t成交价\t价格变动\t成交量(手)\t成交额(元)\t性质";
        assert this.cocoonLineParser.parse(line) == null;
    }

    @Test
    public void testParseValidLine() {
        String line = "15:00:31\t170.51\t--\t82\t1398182\t卖盘";
        Entry entry = this.cocoonLineParser.parse(line);

        Calendar c = Calendar.getInstance();
        c.setTime(entry.getDate());

        assert c.get(Calendar.HOUR_OF_DAY) == 15;
        assert c.get(Calendar.MINUTE) == 0;
        assert c.get(Calendar.SECOND) == 31;
        assert entry.getPrice() == 170.51;
        assert entry.getChange() == 0;
        assert entry.getVolume() == 82;
        assert entry.getValue() == 1398182;
        assert entry.getType().equals("卖盘");
    }

    @Test
    public void testParseValidLine2() {
        String line = "13:42:12\t170.0\t-0.51\t2\t34000\t买盘";
        Entry entry = this.cocoonLineParser.parse(line);

        Calendar c = Calendar.getInstance();
        c.setTime(entry.getDate());

        assert c.get(Calendar.HOUR_OF_DAY) == 13;
        assert c.get(Calendar.MINUTE) == 42;
        assert c.get(Calendar.SECOND) == 12;
        assert entry.getPrice() == 170.0;
        assert entry.getChange() == -0.51;
        assert entry.getVolume() == 2;
        assert entry.getValue() == 34000;
        assert entry.getType().equals("买盘");
    }
}
