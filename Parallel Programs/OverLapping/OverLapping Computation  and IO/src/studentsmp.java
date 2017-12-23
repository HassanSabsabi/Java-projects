/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.rit.pj2.Loop;
import edu.rit.pj2.Task;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author PcMax
 */
public class studentsmp extends Task {

    File srcfile, destfile;
    ConcurrentLinkedQueue<Double> q;
    ArrayList info;
    BufferedReader in;
    BufferedWriter out;
    int number_of_students;

    @Override
    public void main(String[] args) throws Exception {
        q = new ConcurrentLinkedQueue<Double>();
        info = new ArrayList();
        srcfile = new File(args[0]);
        destfile = new File(args[1]);
        in = new BufferedReader(new FileReader(srcfile));
        out = new BufferedWriter(new FileWriter(destfile));
        String line;
        while ((line = in.readLine()) != null) {
            info.add(line);
        }
        number_of_students = info.size();
        System.out.println("Number of students:" + number_of_students);
        System.out.println("Readed All Marks: " + info.toString());
        parallelFor(0, info.size() - 1).schedule(dynamic).exec(new Loop() {
            double s;
            double avg;
            double t;

            @Override
            public void start() {
                s = 0;
                avg = 0;
                t = 0;
            }

            @Override
            public void run(int i) throws Exception {
                String tmp = info.get(i).toString();
                // System.out.println("Thread Rank: "+ rank() +"for Data Index="+i);
                //System.out.println("----Its Data: "+info.get(i).toString());
                String[] splited = tmp.split(" ");
                s = 0;
                for (String splited1 : splited) {
                    t = Integer.parseInt(splited1);
                    s = t + s;
                }
                avg = s / 10;
                q.add(avg);
                //System.out.println("Its AVG:"+ avg);

            }
        });
        System.out.println("Writing To File:" + q.toString());
        while (!q.isEmpty()) {
            out.append(String.valueOf(q.remove()) + "  ::  ");
            out.flush();
        }
        out.append("\n");
        out.close();

    }
}
