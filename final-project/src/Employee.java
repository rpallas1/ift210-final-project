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
     * Salary of the employee.
     */
    private double salary;

    /**
     * Role or job title of the employee.
     */
    private String role;

    /**
     * Default constructor that initializes an employee with default
     * values for each attribute.
     */
    public Employee() {
        this("", "", -1.0, "");
    }

    /**
     * Constructs an employee with the specified ID, name, salary, and role.
     * 
     * @param employeeID   the unique identifier for the employee
     * @param employeeName the full name of the employee
     * @param salary       the salary of the employee
     * @param role         the role or job title of the employee
     */
    public Employee(String employeeID, String employeeName, double salary, String role) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.salary = salary;
        this.role = role;
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
     * Compares this employee to the specified object for equality. Two employees
     * are considered equal if they have the same ID, name, salary, and role.
     * 
     * @param obj the object to compare to
     * @return true if the employees are equal, false otherwise
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
        if (employeeName == null) {
            if (other.employeeName != null)
                return false;
        } else if (!employeeName.equals(other.employeeName))
            return false;
        if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        return true;
    }
}