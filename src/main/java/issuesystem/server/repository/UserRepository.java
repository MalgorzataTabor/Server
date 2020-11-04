package issuesystem.server.repository;

import issuesystem.dto.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepository {

    private static List<User> userList = new ArrayList<>(30);

    public static User addListUser(User user) {
        validateUserForAdd(user);
        boolean success = userList.add(user);

        if (success) {
            return user;
        }
        throw new RuntimeException("Something go wrong while adding user");
    }


    public static User getUserByLogin(String login) {

        return userList.stream()
                .filter(p -> p.getLogin().equalsIgnoreCase(login))
                .findFirst()
                .orElse(null);
    }

    public static boolean removeUser(Integer id) {

        User user = userList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (user != null) {
            userList.remove(user);

            System.out.println(user + " was remove");
            return true;
        } else {

            System.out.println(" Id. User doesn't exists ");
            return false;
        }
    }

    public static List<User> getUserList() {

        return Collections.unmodifiableList(userList);
    }

    private static void validateUserForAdd(User user) {
        if (user == null) {
            throw new RuntimeException("User can't be null");
        }
        if (getUserByLogin(user.getLogin()) != null) {
            throw new RuntimeException("User with same login exist in Repository");
        }
    }
}
