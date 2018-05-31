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
 */
public class PeriodFinding {
    private BigInteger[] f;
    private BigInteger size;
    double[] res;

    public PeriodFinding() {
    }
    /*
    Finds the period of the function if there is one
    f(x) =a^x mod N
    */  
       public int findPeriod(BigInteger N, BigInteger a){
        //Because if the number of iterrations reaches half the size, any more over that would mean the period would be <1
        //Since that would void the rules of the algorithm, there is no point in continuing further
        //If the period is <1 the program would also produce no results
        this.size = N.divide(new BigInteger("2"));
        BigInteger numberN = new BigInteger(String.valueOf(N));
        BigInteger numberA= new BigInteger(String.valueOf(a));
        //Initializing the table array to the number size
        res = new double[size.intValue()];
        //Seperate array for calculating the functions, this seperate to the table array res,
        //This allows the avoidance of null or indexOutOfBounds exceptions if the returnTable was used elsewhere
        f = new BigInteger[size.intValue()];
        int count = 0;
        //No specific reason for this to be an infinite while loop, could be changed to a for loop
        //Originally this was sligtly different as the while condition was (r == -1), changed over the itterations of developement
        //This is purely for personal preference as it seems cleaner
        while(true){
            if(count == size.intValue()){
                break;
            }
            //Specifically made for the first 2 values to be calculated without involving the comparison of results
            //If it were to be allowed, because f is compared to numberA.pow(1), on the 2nd itteration of the loop the program would return an answer
            //for this reason the first two function values are skipped in comparison, but still recorded in else block
            if(count > 1){
                f[count] = numberA.pow(count).mod(numberN);
                if(f[count].equals(numberA.pow(1).mod(numberN))){
                  return count-1;
                }
            }else {
                f[count] = numberA.pow(count).mod(numberN);
            }
            //This is done only after it has been confirmed that f[count] is not the start of a new period
            //If the same value for res and f were to be used, this would mean that the method would
            //output an additional unwanted value at the end of the array for the sequence
            res[count] = f[count].doubleValue();
            count++;
        }
        //Default period return statement, -1
        return -1;
    }
    
    //Serves the purpose of getting the graph data from the process of finding the period
    public double[] returnTable(){
        return res;
    }
}