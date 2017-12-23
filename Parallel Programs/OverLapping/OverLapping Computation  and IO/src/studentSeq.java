/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class studentSeq extends Task {

    ConcurrentLinkedQueue<Double> q;
    File srcfile, destfile;
    ArrayList info;
    int number_of_students;
    double s, avg;

    @Override
    public void main(String[] args) throws Exception {
        srcfile = new File(args[0]);
        destfile = new File(args[1]);
        info = new ArrayList();
        q = new ConcurrentLinkedQueue<Double>();
        BufferedReader in = new BufferedReader(new FileReader(srcfile));
        try (BufferedWriter out = new BufferedWriter(new FileWriter(destfile))) {
            s = 0;
            avg = 0;
            double t = 0;
            String line;
            while ((line = in.readLine()) != null) {
                info.add(line);
            }
            number_of_students = info.size();
            System.out.println("Number of students:" + number_of_students);
            for (int i = 0; i < info.size(); i++) {
                String[] splited = info.get(i).toString().split(" ");
                for (String splited1 : splited) {
                    t = Integer.parseInt(splited1);
                    s = t + s;
                }
                avg = s / 10;
                q.add(avg);
                System.out.println("Its AVG:" + avg);
                s = 0;
                avg = 0;
                t = 0;
            }
            System.out.println("Writing To File:" + q.toString());
            while (!q.isEmpty()) {
                out.append(String.valueOf(q.remove()) + "  ::  ");
                out.flush();
            }
            out.append("\n");
            out.close();
        }
    }
}
