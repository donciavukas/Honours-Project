
import honours.project.CalculateGCD;
import honours.project.ClassicalPart;
import honours.project.PeriodFinding;
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Donatas
 * 
 * Testing class, may be out of date as the program evolved
 */
public class NewClass {
    public static void main(String[] args) {
        BigInteger numberN = new BigInteger("9");
        BigInteger numberA= new BigInteger("2");
        BigInteger number1 = new BigInteger("3");
        BigInteger number2 = new BigInteger("7");
        BigInteger res = numberA.pow(3).mod(numberN);
        double[] list = new double[100];
        long min = Long.MAX_VALUE;
        long max = 0;
        long time = 0;
        long average = 0;
        //System.out.println(numberX.equals(numberX.pow(1).mod(numberN)));
        
//        System.out.println(number1.multiply(number2).compareTo(numberN) == 0);

//          PeriodFinding p = new PeriodFinding();
//          System.out.println(p.findPeriod(numberN, numberX));
        
        ClassicalPart a = new ClassicalPart(numberN);
        
//        for(int i = 0; i < 1000; i++){
//            a.start();
//            time = a.getEnd() - a.getStart();
//            if(min>time){
//                min = time;
//            }
//            if(max<time){
//                max = time;
//            }
//            average = average + time;
//        }
//        
//        System.out.println("The minimum amount taken was "+ min);
//        System.out.println("The maximum amount taken was " +max);
//        System.out.println("The average amount taken was " + average/100);

            //Rounding problem
//        double c = 0.8 - 0.7;
//        double b = 0.1;
//        double f = c-b;
//        System.out.println(f);
        



        

   

        
    }
}
