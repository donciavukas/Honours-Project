/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honours.project;

/**
 *
 * @author Donatas
 * Part of the failed attempt of simulating a quantum computer using Qubits and quantum registries
 * Not implemented in the final results
 */
public class ComplexNumber {
    private double real,ima;
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.ima = imaginary;
    }
    
    public ComplexNumber(double real){
        this.real = real;
        this.ima = 0;
    }
    
    // return a new Complex object whose value is (this + b)
    public ComplexNumber plus(ComplexNumber b) {
        ComplexNumber a = this;             // invoking object
        double real = a.real + b.real;
        double imag = a.ima + b.ima;
        return new ComplexNumber(real, imag);
    }

    // return a new Complex object whose value is (this - b)
    public ComplexNumber minus(ComplexNumber b) {
        ComplexNumber a = this;
        double real = a.real - b.real;
        double imag = a.ima - b.ima;
        return new ComplexNumber(real, imag);
    }

    // return a new Complex object whose value is (this * b)
    public ComplexNumber times(ComplexNumber b) {
        ComplexNumber a = this;
        double real = a.real * b.real - a.ima * b.ima;
        double imag = a.real * b.ima + a.ima * b.real;
        return new ComplexNumber(real, imag);
    }
    
      public double real() { return this.real; }
    public double ima() { return this.ima; }
    
}
