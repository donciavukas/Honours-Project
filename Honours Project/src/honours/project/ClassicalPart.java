/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honours.project;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Calendar;

/**
 *
 * @author Donatas
 */
public class ClassicalPart {

    private BigInteger[] res = new BigInteger[2];
    BigInteger N;
    BigInteger a;
    BigInteger gcd;
    long start = 0;
    long end = 0;
    int r;
    ArrayList table = new ArrayList();

    //Initialization with double input
    public ClassicalPart(BigInteger N, BigInteger a) {
        this.N = N;
        this.a=a;
        this.r = -1;
    }

    //Initialization with single input
    public ClassicalPart(BigInteger N) {
        this.a= BigInteger.ZERO;
        this.N = N;
        this.r = -1;
    }
    
    //Single start method
    public void start() {
        if (this.a.equals(BigInteger.ZERO)) {
            this.singleInput(this.N);
        } else {
            this.doubleInput(this.N, this.a);
        }
    }
        //Double input method, takes in 2 arguments of N&x and calculates an array of 2 values that are the factors of N as well as the period r
        private void doubleInput(BigInteger N, BigInteger var) {
        BigInteger results = BigInteger.ZERO;
        //Recording the time at the start of the execution, to later produce the execution duration
        start = System.nanoTime();
        PeriodFinding period = new PeriodFinding();
        //Default 0 values are assigned to the results factors
        //Step 1
        //Set value for a from the user input
        a= var;
        res[0] = BigInteger.ZERO;
        res[1] = BigInteger.ZERO;
        //Step 2
        //Find the GCD of N and a
        gcd = N.gcd(a);
        //Step 3 
        //If The GCD is more than 1, then it is a nontrivial factor, and immidetialy one of the answers
        //The GCD cannot be <0
        if (!gcd.equals(new BigInteger("1"))) {
            //The first value of the result is added in that case
            res[0] = gcd;
            res[1] = N.divide(gcd);
            results = res[0].multiply(res[1]);
            r = period.findPeriod(N, a);
        }
        //Step 4
        r = period.findPeriod(N, a);
        //Checks if the second value is not at its default 0
        //If it is not equal to 0, the calculations are already done and there is no need to perform them again
        if(res[1].compareTo(BigInteger.ZERO) == 0){
        if (res[0].compareTo(BigInteger.ZERO) == 1) {
            /*
            Because according to the formula, the results can be either of (a^r/2 + 1) or (a^r/2 - 1)
            check if the product is equal to the input
            if not, +1 is used instead of -1 for the second value
            */
            res[1] = N.gcd(a.pow(r/2).subtract(BigInteger.ONE));
            if (!res[0].multiply(res[1]).equals(N)) {
                res[1] = N.gcd(a.pow(r/2).add(BigInteger.ONE));
            }
        } else {
            //Default value assign, if the GCD is equal to 1
            res[0] = N.gcd(a.pow(r/2).add(BigInteger.ONE));
            res[1] = N.gcd(a.pow(r/2).subtract(BigInteger.ONE));
        }
        }

        //Populate the table variable for use in the GUI
        for (int i = 0; i < period.returnTable().length; i++) {
            if (period.returnTable()[i] != 0) {
                this.table.add(period.returnTable()[i]);
                
            }
        }
        //Ending the timer
        end = System.nanoTime();
    }

  
        //Single input method, takes in 1 argument of N and calculates an array of 2 values that are the factors of N as well as the period r
        private void singleInput(BigInteger N) { 
        BigInteger results = BigInteger.ZERO;
        PeriodFinding period = new PeriodFinding();
        //Recording the time at the start of the execution, to later produce the execution duration
        start = System.nanoTime();
        a= BigInteger.ZERO;
        do {
            do {
                //res[0],res[1] assigned a value of ZERO for in case the loop gets repeated, to avoid conflicting old values
                res[0] = BigInteger.ZERO;
                res[1] = BigInteger.ZERO;
                //Step 1
                //Create a random number < N
                a= this.generateNumber();
                //In case a 0 is generated, add plus 1, to avoid null pointers and indeaout of bounds
                //If a becomes = 1, then the results would be 1 * N
                //1*N results are not allowed to proceed, and will return to generate a new number
                //Therefore 1 & 0 are never passed to the final resutlts
                if(a.compareTo(BigInteger.ZERO) == 0){
                    a= a.add(BigInteger.ONE);
                }
                //Step 2
                //Find the GCD of N anda
                gcd = N.gcd(a);
                //Step 3 
                //If The GCD is more than 1, then it is a nontrivial factor, and immidetialy one of the answers
                //The GCD cannot be <0
                if (!gcd.equals(new BigInteger("1"))) {
                    //Factor 1
                    res[0] = gcd;
                    //Factor 2
                    res[1] = N.divide(gcd);
                    //Results of the two factors, not using the initial N value to make sure the calculations are correct
                    results = res[0].multiply(res[1]);
                    r = period.findPeriod(N, a);
                    //Break out of the loop
                    //The inner loop might fail to pass even though the number N is already solved, and both factors are known
                    break;
                }  
                //Step 4
                //Otherwise find the period
                r = period.findPeriod(N, a);          
                //Steps 5 and 6
                //Check certain conditions to be met,
                //if any of them are true, continue back again from step 1.
                /*
                1. Period(r) must be even, because further on it is divided by 2, ais raised to the power of r/2
                2. if r == -1, no period could be found with the current valuea
                3. To avoid results such as 21 = 21 * 1, the GCD of 1 is ignored, same as for res[0] not to be equal to N
                */       
            } while (!(r % 2 == 0) || a.pow(r/2).equals(new BigInteger("-1").mod(N)) || r == -1);
            //If res[1] is not ZERO, that means the calculations are already done and both factors are known
            //Other statements test both factors to have expected values
            if(res[1].compareTo(BigInteger.ZERO) == 0){
            if (1==res[0].compareTo(BigInteger.ZERO)) {
                res[1] = (a.pow(r/2).subtract(BigInteger.ONE)).gcd(N);
                if (!(res[1].multiply(res[0]).equals(N))) {
                    res[1] = (a.pow(r/2).add(BigInteger.ONE)).gcd(N);
                }
            } else {
                res[0] = (a.pow(r/2).add(BigInteger.ONE)).gcd(N);
                res[1] = (a.pow(r/2).subtract(BigInteger.ONE)).gcd(N);
           }
        }
            //Second results calculation if the GCD is equal to 1
            results = results = res[0].multiply(res[1]);
        //Repeat the whole process if the product of the resulting factors is not equal to N
        } while(results.compareTo(N) != 0 || res[1].equals(N)|| res[0].equals(N));
        
        //Populate the sequence table variable for use in the UI from the period 
        for (int i = 0; i < period.returnTable().length; i++) {
            if (period.returnTable()[i] != 0) {
                this.table.add(period.returnTable()[i]);
            }
        }
        //Ending the timer
        end = System.nanoTime();      
    }
    //Getter methods for the factors of N that are used in the UI
    public BigInteger[] resultReturn() {
        return this.res;
    }
    //Generating a random BigInteger type number, with specified bit length less or equal to N
    public BigInteger generateNumber(){
        Random rand = new Random();
        BigInteger number = BigInteger.ZERO;
        do{
                    number= new BigInteger(N.bitLength(), rand);
                }while(number.compareTo(N)>=0);
        return number;
    }

    //Get the sequence from the period class
    public ArrayList dataReturn() {
        return this.table;
    }

    public int getR() {
        return r;
    }

    public BigInteger getGcd() {
        return gcd;
    }
    public long getTime(){
        return end-start;
    }
    
   
    public BigInteger getA() {
        return a;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }
    
    

}
