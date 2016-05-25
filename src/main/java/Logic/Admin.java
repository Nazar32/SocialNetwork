package Logic;

public class Admin extends Person {

    private final String eMail;
    private final String password;
    public static Admin instance;


    private Admin() {

        eMail = "admin";
        password = "1";
    }

    @Override
    public void update() {

    }

    public Admin getInstance() {

        if (instance == null) {

            instance = new Admin();
        }

        return instance;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }
}
