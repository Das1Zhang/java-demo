package Enum;

enum Color{
    RED, GREEN, BLUE;

    private Color(){
        System.out.println("Constructor called for:" + this.toString());
    }

    public void colorInfo(){
        System.out.println("Universal Color");
    }
}

public class Enum{
    public static void main(String[] args){
        Color c1 = Color.RED;
        Color c2 = Color.BLUE;
        System.out.println(c1);
        System.out.println(c2);

        c1.colorInfo();

        for(Color myVar:Color.values()){
            System.out.println(myVar);
        }

        switch(c1){
            case RED:
                System.out.println("RED--");
                break;
            case BLUE:
                System.out.println("BLUE--");
                break;
            case GREEN:
                System.out.println("GREEN--");
                break;
        }

        Color[] arr = Color.values();
        for(Color col:arr){
            System.out.println(col + "at index of :" + col.ordinal());
        }

        System.out.println(Color.valueOf("RED"));
    }
}