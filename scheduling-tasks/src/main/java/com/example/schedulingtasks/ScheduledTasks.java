package com.example.schedulingtasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


@Component
public class ScheduledTasks {

    private static final Logger log = Logger.getLogger(ScheduledTasks.class.getName());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now " + dateFormat.format(new Date()));
    }
}