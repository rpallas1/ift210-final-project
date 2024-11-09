import java.util.ArrayList;

public class DataManager {
    private static DataManager instance = null;
    private ArrayList<Employee> employeeList = new ArrayList<Employee>();

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }

        return instance;
    }

    /**
     * Adds an employee to the employeeList.
     * 
     * @param employee the employee to be added to the list
     */
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    /**
     * Removes an employee from the employeeList.
     * 
     * @param employee the employee to be removed from the list
     */
    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    /**
     * Updates the role of an employee.
     * 
     * @param employee the employee having its role updated
     * @param role     a String representing the role that will be used to update
     *                 the employee
     */
    public void updateEmployeeRole(Employee employee, String role) {
        employee.setRole(role);
    }

    /**
     * Updates the salary of an employee.
     * 
     * @param employee the employee having its salary updated
     * @param salary   a double representing the salary that will be used to update
     *                 the employee
     */
    public void updateEmployeeSalary(Employee employee, double salary) {
        employee.setSalary(salary);
    }

    /**
     * Searches and returns an employee with the specified ID.
     * 
     * @param id the ID of the employee to search for
     * @return the Employee with the specified ID, or null if no employee is found
     */
    public Employee doesEmployeeExist(String id) {
        Employee employee = new Employee(id);
        int index = employeeList.indexOf(employee);

        if (index >= 0) {
            return employeeList.get(index);
        }

        return null;
    }

    public double getTotalSalary() {
        double totalSalary = 0;

        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }

        return totalSalary;
    }

    /**
     * Gets all of the employees from the employeeList.
     * 
     * @return an ArrayList<Employee> that is a copy of the list being stored
     */
    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employeeList);
    }

    public ArrayList<Employee> getEmployeesSortedBySalary() {
        ArrayList<Employee> sortedList = new ArrayList<>(employeeList);
        int length = employeeList.size();

        // Bubble sort
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (sortedList.get(j).getSalary() > sortedList.get(j + 1).getSalary()) {
                    Employee temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }

        return sortedList;
    }
}
