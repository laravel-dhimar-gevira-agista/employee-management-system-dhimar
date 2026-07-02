package service;

import repository.LoginRepository;

public class LoginService {

    private static LoginRepository repo = new LoginRepository();

    public static boolean login(String username, String password) {
        return repo.login(username, password);
    }
}