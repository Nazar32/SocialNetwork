package Logic;

public abstract class Person {

    private String firstName;
    private String surname;
    private String patronymic;
    private int age;
    private char sex;


    public Person(String name, String surname, String patronymic, int age, char sex) {

        this.firstName = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.sex = sex;
    }

    public Person() {
    }

    public char getSex() {
        return sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {

        return surname + " " + firstName + " " + patronymic + " "
                + "Age : " + age + "Sex :" + sex;
    }

    public abstract void update();
}
