package org.basix;

import org.basix.interfaces.TaxCalculator2018;
import org.basix.interfaces.TaxCalculator2019;
import org.basix.interfaces.TaxReport;
import org.basix.mytube.*;
import org.basix.test.Testing;

public class Main {
    public static void main(String[] args) {


        var video = new Video();
        video.setFileName("MahVideio.mp4");
        video.setTitle("Mera video aa gya");
        video.setUser(new User("krishnaJi", "krishna@asf.gom"));

        var processor = new VideoProcessor(new VideoEncoderImpl(), new VideoDatabaseImpl());
        processor.process(video);


       /*
       // Constructor Injection or Poormans code
       var report = new TaxReport(new TaxCalculator2018(10_000));
        report.show();
        // Setter injection
        report.setCalculator(new TaxCalculator2019());
        report.show();*/

        // Method Injection
        /*var report = new TaxReport();
        report.show(new TaxCalculator2018(10_000));
        report.show(new TaxCalculator2019());*/

    }
}