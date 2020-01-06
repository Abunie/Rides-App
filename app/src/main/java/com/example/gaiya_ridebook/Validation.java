package com.example.gaiya_ridebook;
import android.widget.EditText;
import java.util.regex.Pattern;

public class Validation {
    private static final String DATE_REGEX = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    private static final String TIME_REGEX = "^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$";
    private static final String POSDECIMAL_REGEX ="^(\\d*\\.)?\\d+$";

    // Error Messages
    private static final String REQUIRED_MSG = "required";
    private static final String DATE_MSG= "invalid date";
    private static final String TIME_MSG = "invalid time";
    private static final String POSDEC_MSG = "Should be a decimal";

    //Call this to check if the date format is valid.
    public static boolean isDate(EditText editText, boolean required) {
        return isValid(editText, DATE_REGEX, DATE_MSG, required);
    }

    //Call to check if time format is valid
    public static boolean isTime(EditText editText, boolean required) {
        return isValid(editText, TIME_REGEX, TIME_MSG, required);
    }
    //Call to check if it is a non-negative decimal
    public static boolean isPosDec(EditText editText, boolean required) {
        return isValid(editText, POSDECIMAL_REGEX, POSDEC_MSG, required);
    }

    // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);
        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        };

        // text required and editText is blank, so return false
        if ( required && !hasText(editText) ) return false;



        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }







}
