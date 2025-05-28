package Animal;

class Dog extends Animal{
    public Dog(){
        super();
    }
    public Dog(String myName, int myid) {
        super(myName, myid);
    }

    public void move(){
        System.out.println("狗可以跑");
    }

}

public class TestDog{
    public static void main(String[] args){
        Animal a = new Animal();
        Animal b = new Dog();

        a.move();
        b.move();
    }
}