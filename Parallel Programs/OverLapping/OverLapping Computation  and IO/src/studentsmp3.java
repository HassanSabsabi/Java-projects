/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.rit.pj2.Loop;
import edu.rit.pj2.Section;
import edu.rit.pj2.Task;
import static edu.rit.pj2.Task.dynamic;
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
public class studentsmp3 extends Task {

    File srcfile, destfile;
    ArrayList info;
    BufferedReader in;
    BufferedWriter out;
    int num;
    int number_of_students;
    ConcurrentLinkedQueue<Double> q;

    @Override
    public void main(String[] args) throws Exception {
        info = new ArrayList<Double>();
        q = new ConcurrentLinkedQueue<Double>();
        srcfile = new File(args[0]);
        destfile = new File(args[1]);
        in = new BufferedReader(new FileReader(srcfile));
        out = new BufferedWriter(new FileWriter(destfile));
        destfile.setWritable(true);
        String line;
        while ((line = in.readLine()) != null) {
            info.add(line);
        }
        num = info.size();
        number_of_students = info.size();
        System.out.println("Number of students:" + num);
        System.out.println("Readed All Marks: " + info.toString());

        parallelDo(
                new Section() {
            @Override
            public void run() throws Exception {
                parallelFor(0, info.size() - 1).schedule(dynamic).chunk(1).exec(new Loop() {
                    double sum;
                    double t;
                    double avg;

                    @Override
                    public void start() {
                        sum = 0;
                        avg = 0;
                        t = 0;
                    }

                    @Override
                    public void run(int i) throws Exception {
                        String tmp = info.get(i).toString();
                        System.out.println("Thread Rank: " + rank() + "  for Data Index=" + i);
                        System.out.println("----Its Data: " + info.get(i).toString());
                        String[] splited = tmp.split(" ");
                        sum = 0.0;
                        for (String splited1 : splited) {
                            t = Double.parseDouble(splited1);
                            sum = sum + t;
                        }
                        avg = sum / 10;
                        System.out.println("avg : " + avg);
                        q.add(avg);
                        System.out.println("all AVGS Incremently:" + q.toString());
                    }
                });
            }
        }, new Section() {
            @Override
            public void run() throws Exception {
                int now = 0;
                while (now != number_of_students) {
                    if (!q.isEmpty()) {
                        System.out.println("writing for time:" + now);
                        now++;
                        out.append(String.valueOf(q.remove()) + "  ::  ");
                        out.flush();
                    }
                }
                out.append("\n");
                out.close();
            }
        }
        );
    }
}
