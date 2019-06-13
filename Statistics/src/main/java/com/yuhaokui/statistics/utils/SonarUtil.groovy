package com.yuhaokui.statistics.utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SonarUtil {
    static String sonarDir

    @Value('${sonar.dir}')
    String setSonarDir(String dir) {
        this.sonarDir = dir
    }

    Process serviceProcess;

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

    def startSonarService() {
        String startServiceCmd = 'sh ' + SonarUtil.sonarDir + ' console'
        serviceProcess = (startServiceCmd).execute()
        serviceProcess.waitFor()
    }
}
