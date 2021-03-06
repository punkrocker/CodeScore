package com.yuhaokui.statistics.utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import java.nio.file.Path

@Component
class SonarUtil {
    String configFile = 'sonar-project.properties'

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
        String filePath = dir + File.separatorChar + configFile
        File configFile = new File(filePath)
        if (!configFile.exists()) {
            changeFileContent(configFile)
            println(filePath)
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
        String projectPath = file.path.replace(paths[-1], "")
        File pomFile = new File(projectPath + AppConst.POM_FILE)
        if (pomFile.exists()) {
            String buildCmd = "mvn package -Dmaven.test.skip=true"
            Runtime.getRuntime().exec(buildCmd, null, new File(projectPath))
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

    def getDestPath(String path) {
        List<String> destPaths = new ArrayList<>()
        getSonarPath(path, destPaths)
        destPaths
    }

    //获取带sonar配置文件的path
    def getSonarPath(String path, List<String> destPaths) {
        if (new File(path + File.separatorChar + configFile).exists())
            destPaths.add(path)
        else {
            File parentPath = new File(path)
            File[] fileLists = parentPath.listFiles()

            for (File subPath : fileLists)
                if (subPath.isDirectory()) {    //判断元素是不是一个目录
                    getSonarPath(subPath.path, destPaths)
                }
        }
    }
}
