package Logic.Filter;

import Logic.Person;

import java.util.List;

public class AndCriteria implements Criteria {

    private Criteria firstCriteria;
    private Criteria secondCriteria;


    public AndCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> resultingPersons = firstCriteria.meetCriteria(persons);
        return secondCriteria.meetCriteria(resultingPersons);
    }
}
