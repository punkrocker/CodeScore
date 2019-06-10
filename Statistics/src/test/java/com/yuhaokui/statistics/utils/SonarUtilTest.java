package com.yuhaokui.statistics.utils;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

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
    void startSonar() {
        SonarUtil sonarUtil = new SonarUtil();
        sonarUtil.startSonarService();
        String cmd = "curl http://localhost:9000";

    }
}