package Week5;

import java.util.ArrayList;
import java.util.List;

public class Utilizer {
    public static boolean isValidCourseID(String courseID ) {
        List<String> existingIDs = new ArrayList<>();
        return courseID != null && 
               !courseID.trim().isEmpty() && 
               !existingIDs.contains(courseID);
    }
    
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }
    
    public static boolean isValidCredits(int credits) {
        return credits > 0;
    }
    
    public static boolean isValidDate(String begin, String end) {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            java.util.Date beginDate = sdf.parse(begin);
            java.util.Date endDate = sdf.parse(end);
            return endDate.after(beginDate);
        } catch (Exception e) {
            return false;
        }
    }
}
