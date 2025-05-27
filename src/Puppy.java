public class Puppy {
    private int age;
    private String name;
    public Puppy(String name){
        this.name = name;
        System.out.println(("小狗的名字是：" + name));
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public static void main(String[] args){
        Puppy myPuppy = new Puppy("tommy");
        myPuppy.setAge(2);

        int age = myPuppy.getAge();
        System.out.println("小狗的年龄为：" + age);

        System.out.println("变量值：" + myPuppy.getAge());
    }
}
