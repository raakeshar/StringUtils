package com.zillow.Utils;
import java.util.logging.Logger;


/**
 *Class which contains String util methods.
 * Created by rakesh .
 */
public class StringUtils {

    private static final Logger LOGGER = Logger.getLogger(StringUtils.class.getName());

    /*A method to convert string entered in the console to a long if it is a valid number.
    * The strings are assumed to be ascii encoded.
    * The method returns zero if the string contains non numeric characters throwing IllegalArgumentException.
    * If zero is the string , in that case also it returns zero but that has been handled in the StringUtilstest class.
    * */
    public static long stringToLong(String number) {

        try {

            // Check if the string is null or empty
            if (number == null || number.trim().length() == 0) {
                throw new IllegalArgumentException("Number cannot be null/empty.");
            }


            long result = 0;

            // trim the number
            number = number.trim();

            // check for sign as the first character
            boolean negate = false;

            char sign = number.charAt(0);

            if (sign == '+' || sign == '-') {
                if (sign == '-') {
                    negate = true;
                }

                number = number.substring(1);
            }

            LOGGER.info("Number after removing the sign :" + number);
            int length = number.length();


            for (int index = 0; index < length; index++) {
                char digit = number.charAt(index);


                // check if it is a number .
                if (!(digit >= '0' && digit <= '9')) {
                    throw new IllegalArgumentException("Number contains characters other than digits at index " + index);
                }

                result = result * 10 + (digit- '0');

            }
            LOGGER.info("The result is :" + String.valueOf(result));
            // if negative, then subtract from zero to get the proper value.
            if (negate) {
                result = 0 - result;
            }

            //Check if the number is greater than MaxValue.
            if(result > Long.MAX_VALUE)
                return Long.MAX_VALUE;

            //Check if the number is lesser than MinValue.
            if(result < Long.MIN_VALUE)
                return Long.MIN_VALUE;

            // return the final result
            return result;

        } catch (IllegalArgumentException ex) {

            LOGGER.severe(ex.getMessage());
            return 0;
        }
    }

}
