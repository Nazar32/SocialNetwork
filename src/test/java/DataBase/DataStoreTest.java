package DataBase;

import Logic.User;
import org.junit.Test;
import static org.junit.Assert.*;



public class DataStoreTest {

    @Test
    public void getUsers() throws Exception {

        User user = new User("Name", "Surname", "Patronymic", "email", 11, "1111", 'M', 2, 1);
        DataStore.getInstance().insertUser(user);

        for (User user1 : DataStore.getInstance().getUsers()) {

            System.out.println(user1);
        }
        assertEquals(DataStore.getInstance().getUsers().get(1), user);

    }


}