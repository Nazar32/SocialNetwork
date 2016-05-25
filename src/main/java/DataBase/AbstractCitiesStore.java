package DataBase;

import Logic.City;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AbstractCitiesStore {

    public ArrayList<City> getCities() throws SQLException;
}
