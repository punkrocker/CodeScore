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
        String dest = GitUtil.workSpace + gitAddr
        String sperator = File.separatorChar
        int endIndex = dest.lastIndexOf(sperator)
        dest = dest.substring(0, endIndex)
        File destFile = new File(dest)
        if (!destFile.exists()) {
            destFile.mkdir()
        }
        String cmd = "git clone " + GitUtil.baseUrl + gitAddr + ".git " + GitUtil.workSpace + gitAddr
        cmd.execute()
    }

}
