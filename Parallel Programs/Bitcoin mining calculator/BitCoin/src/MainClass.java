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

        long t1, t2;

        Task seq = new MineCoinSeq();
        Task smp = new MineCoinSmp();

        args = new String[2];
        args[0] = "fedcba9876543210";
        args[1] = "16";

        t1 = System.currentTimeMillis();
        seq.main(args);
        t2 = System.currentTimeMillis();
        System.out.println("Seq time" + (t2 - t1));

        t1 = System.currentTimeMillis();
        smp.main(args);
        t2 = System.currentTimeMillis();
        System.out.println("Smp time" + (t2 - t1));
    }
}
