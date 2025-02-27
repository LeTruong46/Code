package Week6;

import java.util.regex.Pattern;

public class Validation {
    public static boolean isValidPhone(String phone) {
        String regex = "^(\\d{10}|\\d{3}[-.\\s]?\\d{3}[-.\\s]?\\d{4}( x\\d{1,4})?|\\d{3}[-.\\s]?\\d{3}[-.\\s]?\\d{4} ext\\d{1,4})$";
        return Pattern.matches(regex, phone);
    }
}
