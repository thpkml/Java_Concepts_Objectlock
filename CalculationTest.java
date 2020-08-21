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

public class CalculationTest {
public static void main(String[] args){
    CalculationQueue printerQueue = new CalculationQueue();
    Thread thread[] = new Thread[10];
    for(int i = 0; i < 10; i++){
        thread[i] = new Thread(new Calculation(printerQueue), "Thread" + i);
    }
    for(int i = 0; i < 10; i++){
        thread[i].start();
    }
}
}