/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honours.project;

/**
 *
 * @author Donatas
 * As of the transition to BigInteger from integer
 * this class is no longer used.
 * Kept primarily for recording project progress
 * 
 */
public class CalculateGCD {
  
    public int gcd(int a, int b){
        int d = 0;
        //If both of the values are even numbers
        //Divide by 2 and add to the power d
        while ((a%2==0) && (b%2==0)){
            a = a/2;
            b = b/2;
            d++;
        }
        while(a != b){
            //System.out.println("Loop gcd");
            //Infinite loops occur if either one of the values is 0
            //To avoid that the gcd return value is 0
            //The gcd being 0 will not pass in further checks in the program
            if(a == 0 || b == 0){
                return 0;
            }
            if(a%2==0){
                a = a/2;
            }else if(b%2==0){
                b = b/2;
            }else if(a>b){
                a = (a-b)/2;
            }else {
                b = (b-a)/2;
            }
        }
        //System.out.println("GCD is " + (a*(int) Math.pow(2, d)));
        return a*(int) Math.pow(2, d);
        
    }
}
