package com.wiysoft.cocoon.rawparser;

import com.wiysoft.cocoon.rawparser.model.Entry;

/**
 * Created by weiliyang on 6/30/15.
 */
public interface CocoonLineParser {

    public Entry parse(String line);
}
