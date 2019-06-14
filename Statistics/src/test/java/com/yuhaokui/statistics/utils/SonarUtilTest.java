package com.yuhaokui.statistics.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
@ComponentScan(basePackages = "com.yuhaokui.statistics.*")
@PropertySource({
        "classpath:application-pro.properties"
})
class SonarUtilTest {
    @BeforeEach
    void cleanFile() {
        String templatePath = System.getProperty("user.dir") + File.separatorChar + "sonar-project.properties";
        File configFile = new File(templatePath);
        if (configFile.exists())
            configFile.delete();
    }

    @Test
    void checkConfigFile() {
        SonarUtil sonarUtil = new SonarUtil();
        String templatePath = sonarUtil.checkConfigFile(System.getProperty("user.dir"));
        System.out.println(templatePath);
        assertNotEquals("", templatePath, templatePath);
    }

    @Test
    void startScan() {
        SonarUtil sonarUtil = new SonarUtil();
        sonarUtil.scanProject("/Users/dennisyu/git_workspace/SanHe/server/");
    }
}