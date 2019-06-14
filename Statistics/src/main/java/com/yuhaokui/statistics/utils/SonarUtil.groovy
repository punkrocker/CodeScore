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

    static String sonarScannerDir

    @Value('${sonar.scanner.dir}')
    String setSonarScannerDir(String dir) {
        this.sonarScannerDir = dir
    }

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
        addMavenJavaProjectConfig(file, paths, sb)
        file.write(sb.toString())
    }

    private void addMavenJavaProjectConfig(File file, String[] paths, StringBuilder sb) {
        String pomFilePath = file.path.replace(paths[-1], AppConst.POM_FILE)
        File pomFile = new File(pomFilePath)
        if (pomFile.exists()) {
            "mvn package".execute()
            sb.append('sonar.java.binaries=target' + (File.separatorChar as String) + 'classes' + '\n')
        }
    }

    def startSonarService() {
        String startServiceCmd = 'sh ' + SonarUtil.sonarDir + ' console'
        Process serviceProcess = startServiceCmd.execute()
        serviceProcess.waitFor()
    }

    def scanProject(String projectDir) {
        String scanCmd = SonarUtil.sonarScannerDir
        File dir = new File(projectDir)
        Process scanProcess = Runtime.getRuntime().exec(scanCmd, null, dir)
        scanProcess.waitFor()
    }
}
