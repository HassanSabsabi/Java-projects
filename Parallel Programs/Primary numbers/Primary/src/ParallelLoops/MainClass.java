/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParallelLoops;

import edu.rit.pj2.Task;

/**
 *
 * @author Micheline
 */
public class MainClass {

    public static void main(String[] args) throws Exception {
        Task seq = new PrimeSeq();
        Task smp = new PrimeSmp();
//prime numbers
        args = new String[16];
        args[0] = "100000000000000003";
        args[1] = "100000000000000013";
        args[2] = "100000000000000019";
        args[3] = "100000000000000021";
        args[4] = "100000000000000003";
        args[5] = "100000000000000013";
        args[6] = "100000000000000019";
        args[7] = "100000000000000021";
        args[8] = "100000000000000003";
        args[9] = "100000000000000013";
        args[10] = "100000000000000019";
        args[11] = "100000000000000021";
        args[12] = "100000000000000003";
        args[13] = "100000000000000013";
        args[14] = "100000000000000019";
        args[15] = "100000000000000021";
        args[12] = "100000000000000003";
        args[13] = "100000000000000013";
        args[14] = "100000000000000019";
        args[15] = "100000000000000021";

        seq.main(args); //execution time: 29080
// ((Actual Threads is 4)) my laptop “Intel CPU CoreTM i3”

//        System.out.println(smp.actualThreads());

        smp.main(args); //execution time: 7397
        smp.threads(3);
        smp.main(args); //execution time: 7767
        smp.threads(2);
        smp.main(args); //execution time: 10215
        smp.threads(1);
        smp.main(args); //execution time: 28431
    }
}
