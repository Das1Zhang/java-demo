package Constructor;

public class SubClass extends SuperClass{
    private int n;
    public SubClass(){
        System.out.println("SubClass()");
    }
    public SubClass(int n){
        super(300);
        System.out.println("SubClass(int n):" + n);
        this.n = n;
    }
}
