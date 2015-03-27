package com.zillow.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * Class to test the StringUtils class.
 * Created by rakesh .
 */
public class StringUtilsTest {

    private static final Logger LOGGER = Logger.getLogger(StringUtilsTest.class.getName());
    public static void main(String[] args)
    {
        test();
    }

    /**
     * A test class for stringToLong.
     * Checks if the entered string is the same as the returned long number.
     * returns void
     */
    public static void test()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            LOGGER.info("The input read is : "+ input);
            long i = StringUtils.stringToLong(input);

            char sign = input.charAt(0);
            if (sign == '+' || sign == '-') {

                input = input.substring(1);
            }

            if(String.valueOf(i).equals(input))
                System.out.println("The method returned the long value: "+ i);

            else
                System.out.println("Please enter the proper input. Input contained a character other than numbers ");
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }
    }
}
