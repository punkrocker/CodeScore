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
            changeFileContent(configFile)
        }
        filePath
    }

    def changeFileContent(File file) {
        String[] paths = file.path.split(File.separatorChar as String)
        //至少有group和project两级
        assert paths.length >= 2
        StringBuilder sb = new StringBuilder()
        sb.append('sonar.projectKey=' + paths[-2] + '\n')
        sb.append('sonar.projectName=' + paths[-3] + paths[-2] + '\n')
        sb.append('sonar.projectVersion=1.0' + '\n')
        sb.append('sonar.sources=src' + '\n')
        file.write(sb.toString())
    }
}
