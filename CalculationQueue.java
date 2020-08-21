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
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CalculationQueue {
    // object of ReentrantLock of type Lock 
    // class ReentrantLock is a basic implementation of the interface Lock
    private final Lock queueLock = new ReentrantLock();
    
    public void calculate(Object document){
         queueLock.lock();
        try{
           Long duration = (long)(Math.random()*5000);
           Double n1 = (double)(Math.random()*100000);
           Double n2 = (double)(Math.random()*100000);
           System.out.println("Calculating " + n1 + " times " 
                   + " the square of " + n2);
           System.out.println("This calculation was given: " 
                   + duration/1000 + " seconds to execute."); 
           System.out.println("Calculation executed exactly on: " 
                   + new Date());
           System.out.println("The answer is: " + n1*n2*n2);
           
           Thread.sleep(duration);
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.printf("%s: Calculation completed !\n", 
                    Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
}