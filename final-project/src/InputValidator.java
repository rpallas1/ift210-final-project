public class InputValidator {
    /**
     * @param id
     * @return
     * @throws Exception
     */
    protected String validateId(String id) throws Exception {
        System.out.println("ID validated");

        if (id.equals("101")) {
            throw new Exception();
        }

        return id;
    }

    /**
     * @param name
     * @return
     * @throws Exception
     */
    protected String validateName(String name) throws Exception {
        System.out.println("Name validated");

        if (name.equals("Ryan")) {
            throw new Exception();
        }

        return name;
    }

    /**
     * @param role
     * @return
     * @throws Exception
     */
    protected String validateRole(String role) throws Exception {
        System.out.println("Role validated");

        if (role.equals("Boss")) {
            throw new Exception();
        }

        return role;
    }

    /**
     * @param salary
     * @return
     * @throws Exception
     */
    protected double validateSalary(String salary) throws Exception {
        System.out.println("Salary validated");
        return Double.parseDouble(salary);
    }
}
