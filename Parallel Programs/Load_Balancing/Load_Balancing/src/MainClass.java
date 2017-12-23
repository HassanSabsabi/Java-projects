/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.rit.pj2.Task;

/**
 *
 * @author ASUS
 */
public class MainClass {

    public static void main(String[] args) throws Exception {

        //variables to calculate execution time
        int t1, t2;

        Task seq = new TotientSeq();
        Task smp = new TotientSmp();

        args = new String[1];
        args[0] = "1000019";

        System.out.println("the sequential execution:");
        t1 = (int) System.currentTimeMillis();
        seq.main(args);
        t2 = (int) System.currentTimeMillis();
        System.out.println("execution time: " + (t2 - t1));

        System.out.println("the parallel execution:");
        t1 = (int) System.currentTimeMillis();
        smp.main(args);
        t2 = (int) System.currentTimeMillis();
        System.out.println("execution time: " + (t2 - t1));
    }
}
