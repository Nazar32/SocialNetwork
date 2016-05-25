package res;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public final class R {

    private static Pattern eMail = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
    private static Pattern password = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
    private static Pattern name = Pattern.compile("^[A-Za-z]{1,20}$");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean matchEmail(String email) {

        return eMail.matcher(email).matches();
    }
    public static boolean matchPassword(String pass) {

        return password.matcher(pass).matches();
    }

    public static boolean matchName(String n) {

        return name.matcher(n).matches();
    }

    public static String formatDate(Date date) {

        return sdf.format(date);
    }

    public static Date parseDate(String date) throws ParseException {

        return sdf.parse(date);
    }

    public static void main(String[] args) {


    }

}
