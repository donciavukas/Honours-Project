/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honours.project;

/**
 *
 * @author Donatas
 * A table entry class consisting of variable a and the resulting function value
 * This class is primarily used to properly populate the tableView piece of the GUI
 */
public class TableEntry {
    //XY x values
    private int x;
    //XY function or could be called y values
    private String function;

    public TableEntry(int number, String value) {
        this.x = number;
        this.function = value;
    }

    public int getX() {
        return x;
    }

    public String getFunction() {
        return function;
    }
    
    
    
}
