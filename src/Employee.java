import java.io.*;

public class Employee {
    private String name;
    private int age;
    private String designation;
    private double salary;

    public Employee(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(int age){
        return age;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }

    public String getDesignation(){
        return designation;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public void printEmployee(){
        System.out.println(this);
    }

    @Override
    public String toString(){
        return "名字："+name+"\n"+
                "年龄："+age+"\n"+
                "职位："+designation+"\n"+
                "薪水："+salary;
    }
}
