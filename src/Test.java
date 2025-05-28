import java.time.Instant;
import java.time.LocalDate;
import java.math.BigInteger;
import java.util.Date;

public class Test {
    public static void main(String[] args)
    {
        Integer x = 5;
        x = x + 10;
        System.out.println(x);

        Number num = 1234.56;
        System.out.println(num.intValue());
        System.out.println(num.longValue());
        System.out.println(num.floatValue());
        System.out.println(num.doubleValue());

        Integer z = 10;
        Double y = 10.0;
        System.out.println(x.doubleValue() == y.doubleValue());

        BigInteger bigInt = new BigInteger("1234567890123445566");
        BigInteger sum = bigInt.add(new BigInteger("1"));

        //====sBuffer类====
        StringBuffer sBuffer = new StringBuffer("hhhh");
        sBuffer.append(",I'm zsh");

        //====关于时间====
        LocalDate today = LocalDate.now();
        System.out.println("当前日期：" + today);

        LocalDate nationalDay = LocalDate.of(2025,10,1);
        System.out.println("国庆节：" + nationalDay);

        LocalDate tomorrow = today.plusDays(1);
        LocalDate nextMonth = today.plusMonths(1);
        LocalDate lastYear = today.minusYears(1);

        System.out.println("明天：" + tomorrow);
        System.out.println("下个月：" + nextMonth);
        System.out.println("去年：" + lastYear);

        //===时间戳===
        Instant now = Instant.now();
        Instant later = now.plusSeconds(60);
        long epochMilli = now.toEpochMilli();

        System.out.println(now);
        System.out.println(later);
        System.out.println(epochMilli);

        Date date = new Date();
        System.out.println(date);

        //====时间比较====
        Date date1 = new Date(121,5,15);
        Date date2 = new Date(121,5,20);

        if(date1.getTime() < date2.getTime()) {
            System.out.println("date1 在 date2 之前");
        } else if(date1.getTime() > date2.getTime()){
            System.out.println("date1 在 date2 之后");
        } else {
            System.out.println("两日期相同");
        }

        System.out.println("date1 在 date2 之前吗？" + date1.before(date2));
        System.out.println("date1 在 date2 之后吗？" + date1.after(date2));
        System.out.println("两日期相同吗？" + date1.equals(date2));

        int result = date1.compareTo(date2);
        if(result < 0){
            System.out.println("date1 在 date2 之前");
        } else if(result > 0){
            System.out.println("date1 在 date2 之后");
        } else{
            System.out.println("两日期相同");
        }

        //=====测量时间=====
        try{
            long start = System.currentTimeMillis();
            System.out.println(new Date() + "\n");
            Thread.sleep(5*60*10);
            System.out.println(new Date() + "\n");
            long end = System.currentTimeMillis();
            long diff = end - start;
            System.out.println("Difference is :" + diff);

        } catch(Exception e) {
            System.out.println("Got an exception");
        }

        for(int i = 0;i<args.length;i++){
            System.out.println("args[" + i + "]:" + args[i]);
        }

        printMax(34, 3, 3, 2, 56,5);
        printMax(new double[]{1,2,3});

    }

    //=====可变参数====
    public static void printMax(double... numbers){
        if(numbers.length == 0){
            System.out.println("No argument passed");
            return;
        }
        double result = numbers[0];
        for(int i = 1;i<numbers.length;i++){
            if(numbers[i] > result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);
    }
}
