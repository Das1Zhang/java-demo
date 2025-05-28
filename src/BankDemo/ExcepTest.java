package BankDemo;

import java.io.*;

public class ExcepTest {
    public static void main(String[] args){
        int a[] = new int[2];
        try{
            System.out.println("Access element three:" + a[3]);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown:  " + e);
        } finally{
            a[0] = 6;
            System.out.println("First element value:" + a[0]);
            System.out.println("The finally statement is executed");
        }
        System.out.println("Out of the block");

    }

    public void checkNumber(int num){
        if(num < 0){
            throw new IllegalArgumentException("Number must be positive");
        }
    }

    public void try_with_resource(){
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))){
            while((line = br.readLine()) != null){
                System.out.println("Line=>"+line);
            }
        }catch(IOException e){
            System.out.println("IOException in try block =>" + e.getMessage());
        }
    }

    public void try_without_resource(){
        String line;
        BufferedReader br = null;
        try{
            System.out.println("Entering try block");
            br = new BufferedReader(new FileReader("test.txt"));
            while((line = br.readLine()) != null){
                System.out.println("Line=>" + line);
            }
        }catch(IOException e){
            System.out.println("IOException in try block =>" + e.getMessage());
        }finally{
            System.out.println("Entering finally block");
            try{
                if(br != null){
                    br.close();
                }
            } catch(IOException e){
                System.out.println("IOException in finally block =>"+e.getMessage());
            }
        }
    }
}

