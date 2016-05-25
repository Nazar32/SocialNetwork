package Logic.Filter;

import Logic.Person;

import java.util.List;

public interface Criteria {

     List<Person> meetCriteria(List<Person> persons);
}
