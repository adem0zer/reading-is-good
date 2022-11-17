package com.adem.readingisgood.common;

import com.adem.readingisgood.mapper.CycleAvoidingMappingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class Utility {
    public static CycleAvoidingMappingContext cycleAvoidingMappingContext = new CycleAvoidingMappingContext();
    public static Logger logger = LoggerFactory.getLogger(Utility.class);

    public static String getNameOfMonth(int month) {
        return Month.of(month).getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault());
    }
}
