package IO;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args){
 /*       Scanner scan = new Scanner(System.in);

        System.out.println("next方式接收：");
        if(scan.hasNext()){
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
/*
        System.out.println("nextLine方式接收：");
        if(scan.hasNextLine()){
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        } */

/*        Scanner scan1 = new Scanner(System.in);
        int i = 0;
        System.out.print("输入整数：");
        if(scan.hasNextInt()){
            i = scan1.nextInt();
            System.out.println("整数数据：" + i);
        } else {
            System.out.println("输入的不是整数！");
        }*/

        System.out.println("请输入数字：");
        Scanner scan2 = new Scanner(System.in);

        double sum = 0;
        int m = 0;

        while(scan2.hasNextDouble()){
            double x = scan2.nextDouble();
            m = m+1;
            sum = sum + x;
        }

        System.out.println(m + "个数对的和为：" + sum);
        System.out.println(m + "个数的平均值为：" + (sum/m));
    }
}
