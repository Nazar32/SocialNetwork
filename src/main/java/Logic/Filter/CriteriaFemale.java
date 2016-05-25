package Logic.Filter;

import Logic.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> foundPersons = new ArrayList<>();

        for (Person person : persons) {

            if (person.getSex() == 'F') {

                foundPersons.add(person);

            }
        }

        return foundPersons;

    }
}
