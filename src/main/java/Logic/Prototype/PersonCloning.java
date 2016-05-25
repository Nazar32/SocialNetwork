package Logic.Prototype;

import Logic.Person;
import Logic.User;

public class PersonCloning implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object clone(Person person) {

        if (person instanceof User) {

            return new User(person.getFirstName(),
                    person.getSurname(),
                    person.getPatronymic(),
                    ((User) person).getEmail(),
                    person.getAge(),
                    ((User) person).getPassword(),
                    person.getSex(),
                    ((User) person).getUser_id(),
                    ((User) person).getCity_id());
        }

        return null;
    }

    public static void main(String[] args) {

        Person person = new Person() {
            @Override
            public void update() {

            }
        };
    }
}
