package system.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return  name;
    }

//    public static boolean isValidFormat(String format, String value) {
//        Date date = null;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(format);
//            date = sdf.parse(value);
//            if (!value.equals(sdf.format(date))) {
//                date = null;
//            }
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//        return date != null;
//    }
}
