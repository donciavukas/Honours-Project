///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package honours.project;
//
//import static java.lang.Math.E;
//import java.util.ArrayList;
//
///**
// *
// * @author Donatas
// */
//public class HonoursProject {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//
//        int N = 21;
//        int a = 4;
////    double[] f = new double[100];
////    int r = -1;  
//        CalculateGCD gcd = new CalculateGCD();
//        PeriodFinding p = new PeriodFinding();
//        
//
//
//        
//
//      ClassicalPart duble = new ClassicalPart(N,a); 
//      duble.start();
//      int[] dubleRes = duble.resultReturn();
//        for(int i = 0; i< 2; i++){
//            System.out.println(dubleRes[i]);
//        }
//         ArrayList table = duble.tableReturn();
//         for(int i = 0; i< table.size(); i++){
//             System.out.println("Value of x: " + i + " " + table.get(i));
//        }
////        ClassicalPart single = new ClassicalPart(N);
////        single.start();
////        int[] singleRes = single.resultReturn();
////        for(int i = 0; i< 2; i++){
////            System.out.println(singleRes[i]);
////        }        
////        ArrayList table = single.tableReturn();
////         for(int i = 0; i< table.size(); i++){
////             System.out.println("Value of x: " + i + " " + table.get(i));
////        }
//
//
////Testing
//
//////value rate was used to check the success rate of getting the results over
//////many itterations of the program
//////was primarily used during developement of the ClassicPart class, to make sure no incorrect input passed.
////        ClassicalPart b = new ClassicalPart(N);
////        int rate = 0;
////        for(int j = 0; j < 100; j++){
////            b.start();
////        int[] c = b.resultReturn();
////        for(int i = 0; i< 2; i++){
////            System.out.println(c[i]);
////        }
////        if(c[0] * c[1] == N){
////            rate++;
////        }
////        }
////        System.out.println(rate);
//    }
//
//}
