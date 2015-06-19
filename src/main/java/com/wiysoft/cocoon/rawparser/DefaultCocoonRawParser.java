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

    @Override
    public List<Entry> parse(String raw) {
        List<Entry> entries = new ArrayList<Entry>();
        if (StringUtils.isEmpty(raw)) {
            return entries;
        }

        
        return entries;
    }

}
