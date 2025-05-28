package Constructor;

public class TestSuperSub {
    public static void main(String[] args){
        System.out.println("---------SubClass 类继承----------");
        SubClass sc1 = new SubClass();
        SubClass sc2 = new SubClass(100);

        System.out.println("---------SubClass2 类继承-----------");
        SubClass2 sc3 = new SubClass2();
        SubClass2 sc4 = new SubClass2(200);
    }
}

// 子类的构造器，如果不使用super调用父类的构造器，那么会自动调用父类的无参构造器