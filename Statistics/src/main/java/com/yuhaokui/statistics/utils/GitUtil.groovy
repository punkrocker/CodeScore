package com.yuhaokui.statistics.utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File

@Component
class GitUtil {

    static String workSpace

    @Value('${git.workspace}')
    String setWorkSpace(String workSpace) {
        this.workSpace = workSpace
    }

    static String baseUrl

    @Value('${git.baseurl}')
    String setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl
    }

    String clone(String gitAddr) {
        String remotePath = gitAddr.replace(GitUtil.baseUrl, "")
                .replace(".git", "")
        String dest = GitUtil.workSpace + remotePath
        String sperator = File.separatorChar
        int endIndex = dest.lastIndexOf(sperator)
        dest = dest.substring(0, endIndex)
        File destFile = new File(dest)
        if (!destFile.exists()) {
            destFile.mkdir()
        }
        String cmd = "git clone " + gitAddr + " " + GitUtil.workSpace + remotePath
//        git clone没有打印信息，所以需要打印执行的命令
        println(cmd)
        println(cmd.execute().text)
        GitUtil.workSpace + remotePath
    }

}
