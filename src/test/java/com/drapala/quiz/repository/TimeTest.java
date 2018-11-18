package com.drapala.quiz.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Timer;

@Slf4j
public class TimeTest {

    LocalTime localTime = LocalTime.now();

    double a = 0;
    double b;
    double c;
    String s = "";

    @Test
    public void getDuration() {

    log.info("Now is {}", localTime);
    long start = System.currentTimeMillis();

    for (int i=0; i<10000; i++) {
        a = i*7 +5%((i+2)*(i+1));
        b = a*i*i +0.01;
        c=a*b +b%a;
        s += a + b + c;
        s.split("1");
    }

    LocalTime secondTIme = LocalTime.now();
    long stop = System.currentTimeMillis();
    int duration = (int) (stop - start)/1000;

    log.info("Now is {}", secondTIme);

    int difference = localTime.compareTo(secondTIme);



    log.info("Difference {}", duration);

    }

}
