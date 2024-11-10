package helpers;

import java.util.regex.Pattern;

import exceptions.InputException;
import exceptions.MenuExitedException;

public class InputValidator {
    public String validateId(String id) throws InputException, MenuExitedException {
        id = id.trim();

        isEmpty(id);
        isExitingMenu(id);

        // Can only contain non-whitespace characters
        String regex = "\\S+";

        if (!Pattern.matches(regex, id)) {
            throw new InputException("ID cannot contain whitespace");
        }

        return id;
    }

    public String validateName(String name) throws InputException, MenuExitedException {
        name = name.trim();

        isEmpty(name);
        isExitingMenu(name);

        // Cannot contain digits
        String regex = "^[^0-9]+$";

        if (!Pattern.matches(regex, name)) {
            throw new InputException("Name cannot be contain numbers");
        }

        return name;
    }

    public String validateRole(String role) throws InputException, MenuExitedException {
        role = role.trim();

        isEmpty(role);
        isExitingMenu(role);

        return role;
    }

    public double validateSalary(String salary) throws InputException, MenuExitedException {
        isExitingMenu(salary);

        try {
            double result = Double.parseDouble(salary);

            if (result < 0) {
                throw new InputException("Salary cannot be negative");
            }

            return result;
        } catch (NumberFormatException nfe) {
            throw new InputException("Salary can only contains numbers");
        }
    }

    private void isEmpty(String input) throws InputException {
        if (input.trim().isEmpty()) {
            throw new InputException("Input cannot be empty");
        }
    }

    private void isExitingMenu(String input) throws MenuExitedException {
        if (input.toLowerCase().equals("q")) {
            throw new MenuExitedException();
        }
    }
}
