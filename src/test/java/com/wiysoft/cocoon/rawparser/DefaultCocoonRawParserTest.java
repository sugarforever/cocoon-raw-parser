package com.wiysoft.cocoon.rawparser;

import com.wiysoft.cocoon.rawparser.model.Entry;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

/**
 * Created by weiliyang on 6/30/15.
 */
public class DefaultCocoonRawParserTest {

    private DefaultCocoonRawParser defaultCocoonRawParser;

    @Before
    public void setup() {
        this.defaultCocoonRawParser = new DefaultCocoonRawParser();
        this.defaultCocoonRawParser.setCocoonLineParser(new DefaultCocoonLineParser());
    }

    @Test
    public void testParse() {
        String raw = "成交时间\t成交价\t价格变动\t成交量(手)\t成交额(元)\t性质";
        raw += "\n" + "15:00:31\t170.51\t--\t82\t1398182\t卖盘";
        raw += "\n" + "13:42:12\t170.0\t-0.51\t2\t34000\t买盘";

        List<Entry> entries = this.defaultCocoonRawParser.parse(raw);
        assert entries.size() == 2;

        Entry first = entries.get(0);
        Entry second = entries.get(1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(first.getDate());
        assert calendar.get(Calendar.HOUR_OF_DAY) == 15;
        assert calendar.get(Calendar.MINUTE) == 0;
        assert calendar.get(Calendar.SECOND) == 31;
        assert first.getPrice() == 170.51;
        assert first.getChange() == 0.0;
        assert first.getVolume() == 82;
        assert first.getValue() == 1398182;
        assert first.getType().equals("卖盘");

        calendar.setTime(second.getDate());
        assert calendar.get(Calendar.HOUR_OF_DAY) == 13;
        assert calendar.get(Calendar.MINUTE) == 42;
        assert calendar.get(Calendar.SECOND) == 12;
        assert second.getPrice() == 170.0;
        assert second.getChange() == -0.51;
        assert second.getVolume() == 2;
        assert second.getValue() == 34000;
        assert second.getType().equals("买盘");
    }

    @Test
    public void testParse2() {
        String raw = "成交时间\t成交价\t价格变动\t成交量(手)\t成交额(元)\t性质";
        List<Entry> entries = this.defaultCocoonRawParser.parse(raw);
        assert entries.size() == 0;
    }
}
