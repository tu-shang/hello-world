package backend;

import backend.service.UserService;

public class App {

    public static void main(String[] args) {
        UserService userService = new UserService();

        System.out.println(userService.getWelcomeMessage());
        System.out.println(userService.getPersonalWelcomeMessage("Dusan"));
        System.out.println(userService.createTaskSummary("SQ TDD Aufgabe", "2025-01-15"));
    }
}
