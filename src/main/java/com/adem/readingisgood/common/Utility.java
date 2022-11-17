package com.adem.readingisgood.common;

import com.adem.readingisgood.mapper.CycleAvoidingMappingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    public static CycleAvoidingMappingContext cycleAvoidingMappingContext = new CycleAvoidingMappingContext();
    public static Logger logger = LoggerFactory.getLogger(Utility.class);

    public static final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    public static String getNameOfMonth(int month) {
        return Month.of(month).getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault());
    }

    public static boolean validate(String value, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
