package Logic.Filter;

import Logic.Person;

import java.util.List;

public class OrCriteria implements Criteria {

    private Criteria firstCriteria;
    private Criteria secondCriteria;


    public OrCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> firstCriteriaPersons = firstCriteria.meetCriteria(persons);
        List<Person> secondCriteriaPersons = secondCriteria.meetCriteria(persons);

        for (Person person : firstCriteriaPersons) {

            if (!secondCriteriaPersons.contains(person)) {

                secondCriteriaPersons.add(person);
            }
        }

        return secondCriteriaPersons;
    }
}
