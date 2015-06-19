package com.wiysoft.cocoon.rawparser;

import com.wiysoft.cocoon.rawparser.model.Entry;

import java.util.List;

/**
 * Created by weiliyang on 6/19/15.
 */
public interface CocoonRawParser {

    public List<Entry> parse(String raw);

}
