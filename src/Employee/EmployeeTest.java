package Employee;

public class EmployeeTest {
    public static void main(String[] args){
        Employee empOne = new Employee("RUNOOB1");
        Employee empTwo = new Employee("RUNOOB2");

        empOne.setAge(26);
        empOne.setDesignation("高级程序员");
        empOne.setSalary(1000);
        empOne.printEmployee();

        empTwo.setAge(21);
        empTwo.setDesignation("菜鸟程序员");
        empTwo.setSalary(500);
        empTwo.printEmployee();

    }
}
