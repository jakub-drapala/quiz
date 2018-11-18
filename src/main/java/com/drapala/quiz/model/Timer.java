package com.drapala.quiz.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Timer {


    private long start;

    private long stop;

    public void startTimer() {
        this.start = System.currentTimeMillis();
    }

    public void stopTimer() {
        this.stop = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        stopTimer();
        long duration =  stop - start;
        return String.valueOf(duration/1000);
    }
}
