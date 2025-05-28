package Constructor;

public class SuperClass {
    private int n;

    public SuperClass(){
        System.out.println("SuperClass()");
    }

    public SuperClass(int n){
        System.out.println("SuperClass(int n)");
        this.n = n;
    }
}
