package managers;

import java.util.ArrayList;
import models.Employee;

/**
 * Manages employee data and operations on the employee list. DataManager is a
 * singleton class, allowing a single instance to manage all employee-related
 * data and actions within the application.
 * 
 * @author Ryan Pallas
 *         created on 11/11/24
 */
public class DataManager {
    private static DataManager instance = null;
    private ArrayList<Employee> employeeList = new ArrayList<Employee>();

    /**
     * Private constructor to prevent instantiation from other classes.
     * Use getInstance() to access the singleton instance.
     */
    private DataManager() {
    }

    /**
     * Returns the singleton instance of DataManager. If no instance exists,
     * a new one is created.
     *
     * @return the singleton instance of DataManager
     */
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }

        return instance;
    }

    /**
     * Adds a new employee to the employee list.
     *
     * @param employee the Employee to add
     * @return true if the employee was added successfully, false otherwise
     */
    public boolean addEmployee(Employee employee) {
        return employeeList.add(employee);
    }

    /**
     * Removes an employee from the employee list.
     *
     * @param employee the Employee to remove
     * @return true if the employee was removed successfully, false otherwise
     */
    public boolean removeEmployee(Employee employee) {
        return employeeList.remove(employee);
    }

    /**
     * Updates an existing employee in the employee list by replacing the entry
     * with the same ID.
     *
     * @param employee the Employee with updated details
     * @return the updated Employee if successful, or null if the employee was not
     *         found
     */
    public Employee updateEmployee(Employee employee) {
        int index = employeeList.indexOf(employee);

        if (index >= 0) {
            employeeList.set(index, employee);
            return employee;
        }

        return null;
    }

    /**
     * Searches for an employee by their ID in the employee list.
     *
     * @param id the ID of the employee to search for
     * @return a copy of them Employee with the specified ID, or null if no employee
     *         is found
     */
    public Employee doesEmployeeExist(String id) {
        Employee employee = new Employee(id);
        int index = employeeList.indexOf(employee);

        if (index >= 0) {
            return new Employee(employeeList.get(index));
        }

        return null;
    }

    /**
     * Calculates the total salary of all employees in the employee list
     * 
     * @return the total salary of all employees
     */
    public double getTotalSalary() {
        double totalSalary = 0;

        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }

        return totalSalary;
    }

    /**
     * Retrieves a copy of the employee list.
     * 
     * @return an ArrayList<Employee> that is a copy of the list being stored
     */
    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employeeList);
    }

    /**
     * Retrieves a copy of the employee list sorted by salary.
     * 
     * @return an ArrayList<Employee> containing all employees
     */
    public ArrayList<Employee> getEmployeesSortedBySalary() {
        ArrayList<Employee> sortedList = new ArrayList<>(employeeList);
        int length = employeeList.size();

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (sortedList.get(j).getSalary() < sortedList.get(j + 1).getSalary()) {
                    Employee temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }

        return sortedList;
    }
}
