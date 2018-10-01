package system.dao;

import org.springframework.stereotype.Repository;
import system.model.User;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {
    private List<User> users = Arrays.asList(
            //new User("admin", "admin"),
            //new User("user1", "user1"),
            //new User("sd","sd")
            new User("bbbb"),new User("aaa")
    );

    public List<User> getAllUsers() {
        return users;
    }
}
