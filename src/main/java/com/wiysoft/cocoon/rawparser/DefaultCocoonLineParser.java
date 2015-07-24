package com.wiysoft.cocoon.rawparser;

import com.wiysoft.cocoon.rawparser.common.Utilities;
import com.wiysoft.cocoon.rawparser.model.Entry;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by weiliyang on 6/30/15.
 */
public class DefaultCocoonLineParser implements CocoonLineParser {

    public static final int COUNT_OF_FIELDS_PER_LINE = 6;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Override
    public Entry parse(String line) {
        Entry entry = null;
        if (StringUtils.isEmpty(line))
            return entry;

        String[] fields = line.trim().split("\t");
        if (fields.length == COUNT_OF_FIELDS_PER_LINE) {
            entry = new Entry();

            String strTime = fields[0];
            Date date = Utilities.parseDate(DATE_FORMAT, strTime);
            if (date == null) {
                return null;
            } else {
                entry.setDate(date);
            }

            String strPrice = fields[1];
            Float price = Utilities.parseFloat(strPrice, null);
            if (price == null) {
                return null;
            } else {
                entry.setPrice(price);
            }

            String strChange = fields[2];
            Float change = Utilities.parseFloat(strChange, 0.0f);
            if (change == null) {
                return null;
            } else {
                entry.setChange(change);
            }

            String strVolume = fields[3];
            Long volume = Utilities.parseLong(strVolume, 0L);
            if (volume == null) {
                return null;
            } else {
                entry.setVolume(volume);
            }

            String strValue = fields[4];
            Long value = Utilities.parseLong(strValue, 0L);
            if (value == null) {
                return null;
            } else {
                entry.setValue(value);
            }

            String strType = fields[5];
            entry.setType(strType);
        }

        return entry;
    }


}
