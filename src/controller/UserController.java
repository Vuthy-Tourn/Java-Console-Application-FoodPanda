package controller;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private static Map<String, String> users = new HashMap<>();
    static {
        users.put("Vuthy", "168");
    }

    public static boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}