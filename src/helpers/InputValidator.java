package helpers;

import java.util.regex.Pattern;

import exceptions.InputException;
import exceptions.MenuExitedException;

/**
 * A utility class for validating user input in various fields.
 * <p>
 * This class provides methods for validating input such as IDs, names, roles,
 * and salaries.
 * It performs checks like ensuring non-empty inputs, matching specific
 * patterns, and handling
 * special cases such as menu exit commands.
 * </p>
 * 
 * @author Ryan Pallas
 *         created on 11/11/24
 */
public class InputValidator {
    /**
     * Validates an ID string.
     * <p>
     * The ID is first trimmed, and then checked for the following conditions:
     * <ul>
     * <li>It must not be empty.</li>
     * <li>It must not contain whitespace characters.</li>
     * <li>If the user enters "q", the menu exit exception is triggered.</li>
     * </ul>
     * </p>
     * 
     * @param id the ID string to validate.
     * @return the validated ID string.
     * @throws InputException      if the ID contains whitespace.
     * @throws MenuExitedException if the user enters "q" to exit the menu.
     */
    public String validateId(String id) throws InputException, MenuExitedException {
        id = id.trim();

        isEmpty(id);
        isExitingMenu(id);

        String regex = "\\S+";

        if (!Pattern.matches(regex, id)) {
            throw new InputException("ID cannot contain whitespace");
        }

        return id;
    }

    /**
     * Validates a name string.
     * <p>
     * The name is first trimmed and checked for the following conditions:
     * <ul>
     * <li>It must not be empty.</li>
     * <li>It must not contain numbers.</li>
     * <li>If the user enters "q", the menu exit exception is triggered.</li>
     * </ul>
     * </p>
     * 
     * @param name the name string to validate.
     * @return the validated name string.
     * @throws InputException      if the name contains numbers or is empty.
     * @throws MenuExitedException if the user enters "q" to exit the menu.
     */
    public String validateName(String name) throws InputException, MenuExitedException {
        name = name.trim();

        isEmpty(name);
        isExitingMenu(name);

        String regex = "^[^0-9]+$";

        if (!Pattern.matches(regex, name)) {
            throw new InputException("Name cannot be contain numbers");
        }

        return name;
    }

    /**
     * Validates a role string.
     * <p>
     * The role is first trimmed and checked to ensure it is not empty.
     * If the user enters "q", the menu exit exception is triggered.
     * </p>
     * 
     * @param role the role string to validate.
     * @return the validated role string.
     * @throws InputException      if the role is empty.
     * @throws MenuExitedException if the user enters "q" to exit the menu.
     */
    public String validateRole(String role) throws InputException, MenuExitedException {
        role = role.trim();

        isEmpty(role);
        isExitingMenu(role);

        return role;
    }

    /**
     * Validates a salary string.
     * <p>
     * The salary is first checked to see if it can be parsed as a double. It must
     * also be
     * a non-negative value.
     * </p>
     * 
     * @param salary the salary string to validate.
     * @return the validated salary as a double.
     * @throws InputException      if the salary cannot be parsed as a number or is
     *                             negative.
     * @throws MenuExitedException if the user enters "q" to exit the menu.
     */
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

    /**
     * Checks if the input is empty (after trimming).
     * <p>
     * If the input is empty, an {@link InputException} is thrown.
     * </p>
     * 
     * @param input the string input to check.
     * @throws InputException if the input is empty.
     */
    private void isEmpty(String input) throws InputException {
        if (input.trim().isEmpty()) {
            throw new InputException("Input cannot be empty");
        }
    }

    /**
     * Checks if the input is a command to exit the menu.
     * <p>
     * If the input is "q" (case-insensitive), a {@link MenuExitedException} is
     * thrown.
     * </p>
     * 
     * @param input the string input to check.
     * @throws MenuExitedException if the input is "q".
     */
    private void isExitingMenu(String input) throws MenuExitedException {
        if (input.toLowerCase().equals("q")) {
            throw new MenuExitedException();
        }
    }
}
