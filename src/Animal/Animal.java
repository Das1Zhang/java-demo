package Animal;// java不支持多继承，但支持多重继承

public class Animal {
    private String name;
    private int id;
    public Animal(){
        name = "xxxx";
        id = -1;
    }
    public Animal(String myName, int myid){
        name = myName;
        id = myid;
    }
    public void eat(){
        System.out.println(name+" is eating");
    }
    public void sleep(){
        System.out.println(name+" is sleeping");
    }
    public void introduction(){
        System.out.println("hello I'm NO." + id + " " + name + ".");
    }

    public void move(){
        System.out.println("动物可以移动");
    }
}
