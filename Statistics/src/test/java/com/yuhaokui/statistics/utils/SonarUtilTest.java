package com.yuhaokui.statistics.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SonarUtilTest {

    @Test
    void checkConfigFile() {
        SonarUtil sonarUtil = new SonarUtil();
        String templatePath = sonarUtil.checkConfigFile(System.getProperty("user.dir"));
        System.out.println(templatePath);
        assertNotEquals("", templatePath, templatePath);
    }
}