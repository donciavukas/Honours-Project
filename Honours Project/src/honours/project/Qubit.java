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
public class Qubit {
    private boolean superposition;
    private int value;
    private ComplexNumber probability0;
    private ComplexNumber probability1;
    
    public Qubit(ComplexNumber a, ComplexNumber b){
        if(!((a.times(a).plus(b.times(b)).real()==1d) && (a.times(a).plus(b.times(b)).ima()==0d))){
            System.out.println("Error");
        }else{
            probability0 = a;
            probability1 = b;
            superposition = true;
        }
    }
    
    public boolean observe(){
        
        if(superposition){
            superposition = false;
            if((probability0.times(probability0).real()>Math.random()) && (probability0.times(probability0).ima()==0d)){
                value =1;}else{
                value = 0;
            }
        }
        if(value == 1){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    
    
}
