package com.yuhaokui.statistics;

import com.yuhaokui.statistics.utils.SonarUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = "com.yuhaokui.statistics.*")
public class StatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplication.class, args);
        StartSonar();
    }

    private static void StartSonar() {
        SonarService sonarService = new SonarService();
        sonarService.start();
    }

    static class SonarService extends Thread {
        @Override
        public void run() {
            SonarUtil sonarUtil = new SonarUtil();
            sonarUtil.startSonarService();
        }
    }
}
