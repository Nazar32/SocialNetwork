package Logic;

public class User extends Person {

    private int user_id;
    private int city_id;
    private String eMail;
    private String password;


    public User(String name, String surname, String patronymic, String e_mail, int age, String password, char sex, int user_id, int city_id) {

        super(name, surname, patronymic, age, sex);
        this.user_id = user_id;
        this.city_id = city_id;
        this.eMail = e_mail;
        this.password = password;
    }

    public void subscribeToCommunity(Community community) {

        community.addSubsriber(this);

    }

    public User(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return eMail;
    }

    public String getPassword() {

        return password;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {


    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getSurname() + " " + getPatronymic() + " " + getPassword() + " " + getEmail() + " " + getCity_id() + " " + getUser_id() + " " + getAge();

    }

    @Override
    public boolean equals(Object obj) {

        return this.getUser_id() == ((User) obj).getUser_id() &&
                this.getAge() == ((User) obj).getAge() &&
                this.getCity_id() == ((User) obj).getCity_id() &&
                this.getFirstName().equals(((User) obj).getFirstName()) &&
                this.getSurname().equals(((User) obj).getSurname()) &&
                this.getEmail().equals(((User) obj).getEmail()) &&
                this.getPassword().equals(((User) obj).getPassword()) &&
                this.getPatronymic().equals(((User) obj).getPatronymic()) &&
                this.getSex() == ((User) obj).getSex();
    }

    public static void main(String[] args) {


    }

    @Override
    public void update() {


    }
}


