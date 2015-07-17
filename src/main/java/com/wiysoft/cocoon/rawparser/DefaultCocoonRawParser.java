package com.wiysoft.cocoon.rawparser;

import com.wiysoft.cocoon.crawler.CocoonCrawler;
import com.wiysoft.cocoon.rawparser.model.Entry;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiliyang on 6/19/15.
 */
public class DefaultCocoonRawParser implements CocoonRawParser {

    private CocoonLineParser cocoonLineParser;

    public void setCocoonLineParser(CocoonLineParser cocoonLineParser) {
        this.cocoonLineParser = cocoonLineParser;
    }

    @Override
    public List<Entry> parse(String raw) {
        List<Entry> entries = new ArrayList<Entry>();
        if (StringUtils.isEmpty(raw)) {
            return entries;
        }

        if (this.cocoonLineParser == null) {
            return entries;
        }

        String[] lines = raw.split(LINE_SEPARATOR);
        for (String line : lines) {
            Entry entry = this.cocoonLineParser.parse(line);
            if (entry != null) {
                entries.add(entry);
            }
        }

        return entries;
    }

}
