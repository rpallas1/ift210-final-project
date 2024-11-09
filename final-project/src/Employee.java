/**
 * Represents an employee within the Company Management System,
 * storing details such as ID, name, salary, and role. Includes
 * methods for accessing and modifying employee attributes, as
 * well as overrides for string representation and equality checks.
 */
class Employee {
    /**
     * Unique identifier for the employee.
     */
    private String employeeID;

    /**
     * Full name of the employee.
     */
    private String employeeName;

    /**
     * Role or job title of the employee.
     */
    private String role;

    /**
     * Salary of the employee.
     */
    private double salary;

    /**
     * 
     */
    public Employee() {
    }

    /**
     * @param id
     */
    public Employee(String id) {
        employeeID = id;
    }

    /**
     * Constructs an employee with the specified ID, name, salary, and role.
     * 
     * @param employeeID   the unique identifier for the employee
     * @param employeeName the full name of the employee
     * @param salary       the salary of the employee
     * @param role         the role or job title of the employee
     */
    public Employee(String employeeID, String employeeName, String role, double salary) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.role = role;
        this.salary = salary;
    }

    /**
     * Returns the employee ID.
     * 
     * @return the unique identifier for the employee
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the employee ID.
     * 
     * @param employeeID the unique identifier to assign to the employee
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Returns the employee's name.
     * 
     * @return the full name of the employee
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets the employee's name.
     * 
     * @param employeeName the full name to assign to the employee
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Returns the employee's salary.
     * 
     * @return the salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the employee's salary.
     * 
     * @param salary the salary to assign to the employee
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns the employee's role.
     * 
     * @return the role or job title of the employee
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the employee's role.
     * 
     * @param role the role or job title to assign to the employee
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Formats and displays a row in the employee table with ID, name, role, and
     * salary.
     * 
     * @param id     the employee ID
     * @param name   the employee's name
     * @param role   the employee's role
     * @param salary the employee's salary
     */
    public void tableRow() {
        System.out.printf("| %-10s | %-15s | %-15s | %-12.2f |\n", employeeID, employeeName, role, salary);
    }

    /**
     * Returns a string representation of the employee, including ID, name, salary,
     * and role, formatted as "Employee [employeeID=..., employeeName=...,
     * salary=..., role=...]".
     * 
     * @return a string representation of the employee
     */
    @Override
    public String toString() {
        return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", salary=" + salary
                + ", role=" + role + "]";
    }

    /**
     * Two Employees are considered equal if they have the same ID.
     * 
     * @param obj any object to compare against this Employee
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (employeeID == null) {
            if (other.employeeID != null)
                return false;
        } else if (!employeeID.equals(other.employeeID))
            return false;
        return true;
    }

}