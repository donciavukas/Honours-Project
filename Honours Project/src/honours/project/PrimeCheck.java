/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honours.project;

import java.math.BigInteger;

/**
 *
 * @author Donatas
 * The class that is used for input variable N testing
 * if the number is certainly prime or a prime power, the methods will return TRUE
 */
public class PrimeCheck {

    //A simple function to check wether a number is a prime or not
    //The function starts from 2 since 2 by itself is a prime number
    public boolean isPrime(BigInteger N) {
        //Type changing from BigInteger into a double, as they are easier to manipulate in calculations
        double n = N.doubleValue();
        //Condition for the loop to stop after the product of 2*i reaches an equal or larger size than n
        for (int i = 2; 2 * i < n; i++) {
            if (n % i == 0) {
                //If N is divisable by i, that means it is not a prime number and the method returns isPrime=false
                //If it were a prime number only 1 and n would have 0 remainder,
                //because i starts at 2 and can never reach n, this will not pass if the number is prime
                return false;
            }
        }
        //Default return statement, isPrime=true
        return true;
    }

    //A function to check whether the input is a power of a prime number like 9=3^3
    public boolean primePow(BigInteger n) {
        //Start at value of k = 2.0
        //This is because the first root would be a square root
        //Math.pow(N,1/1) would always give true at the first itteration and fail to perform its purpose
        //Type changing to double for simpler manipulation
        double N = n.doubleValue();
        double k = 2.0;
        //Intermediary values that can take advantage of the rounding issue of java, initially set to 0.0
        double dres = 0.0;
        double ires = 0.0;
        double diff = 0.0;
        //
        //Loop statement, that comparse a natural logarithm that was created by dividing two Math.log() objects to obtain what is required.
        while (k <= (Math.log(N) / Math.log(2.0))) {
            dres = Math.pow(N, 1.0 / k);
            ires = Math.round(dres);
            diff = Math.abs(dres - ires);
            //Because of rounding errors diff could contain incorrect numbers
            //Prime powers diferences however always returns 0.0
            if (diff == 0.0) {
                return true;
            }
            //A testing statements that uses the last bits of a number, might work some times
            if (diff == Math.ulp(10.0)) {
                return true;
            }
            k++;
        }
        return false;
    }
}
