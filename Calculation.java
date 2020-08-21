/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectlock;

/**
 *
 * @author admin
 */

import java.lang.Thread;

public class Calculation implements Runnable{
    
    // declaring reference type
    private CalculationQueue calculationQueue;
    
    public Calculation(CalculationQueue calculationQueue){
        this.calculationQueue = calculationQueue;
    }
    @Override
    public void run(){
        System.out.printf("%s: Starting a calculation: \n", 
                Thread.currentThread().getName());

        calculationQueue.calculate(new Object());
        
    }
}