/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.rit.pj2.Task;

/**
 *
 * @author PcMax
 */
public class MainClass {

    public static void main(String[] args) throws Exception {
        args = new String[2];
        args[0] = "input.txt";
        args[1] = "output.txt";

        Task seq = new studentSeq();

        long t1 = System.currentTimeMillis();
        seq.main(args);
        long t2 = System.currentTimeMillis();
        System.out.println("Seq Exec:" + (t2 - t1));
        System.out.println("----------------------------");

        Task smp = new studentsmp();
        long t3 = System.currentTimeMillis();
        smp.main(args);
        long t4 = System.currentTimeMillis();
        System.out.println("Smp Exec:" + (t4 - t3));
        System.out.println("----------------------------");

        Task smp3;
        smp3 = new studentsmp3();

        long t5 = System.currentTimeMillis();
        smp3.main(args);
        long t6 = System.currentTimeMillis();
        System.out.println("Smp3 Exec:" + (t6 - t5));
        System.out.println("----------------------------");

    }
}
