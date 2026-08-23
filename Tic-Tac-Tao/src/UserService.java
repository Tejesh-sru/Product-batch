import java.util.HashMap;
public class UserService {
    private HashMap<String, User> users = new HashMap<>();
    public boolean register(String username, int password) {
        if (users.containsKey(username)) {
            return false;
        }
        User user = new User(username, password);
        users.put(username, user);
        return true;
    }
    public User login(String username, int password) {
        if (!users.containsKey(username)) {
            return null;
        }
        User user = users.get(username);
        if (user.getPassword() == password) {
            return user;
        }
        return null;
    }
    public void showAllUsers() {
        for (String username : users.keySet()) {
            System.out.println(username);
        }
    }
}