package com.yuhaokui.statistics.utils

import org.springframework.core.io.ClassPathResource

import javax.annotation.Resource
import java.nio.file.Files
import java.nio.file.Paths

class SonarUtil {

    String checkConfigFile(String dir) {
        String filePath = dir + File.separatorChar + 'sonar-project.properties'
        File configFile = new File(filePath)
        if (!configFile.exists()) {
            File file = new File('src/main/resources/sonar-template')
            Files.copy(Paths.get(file.path), Paths.get(filePath))
        }
        filePath
    }
}
