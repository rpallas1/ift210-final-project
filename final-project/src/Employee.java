public class Employee {
    private String employeeID;
    private String employeeName;
    private double salary;
    private String role;

    public Employee() {
        this("", "", -1.0, "");
    }

    public Employee(String employeeID, String employeeName, double salary, String role) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.salary = salary;
        this.role = role;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", salary=" + salary
                + ", role=" + role + "]";
    }

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