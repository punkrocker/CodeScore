package com.yuhaokui.statistics.utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

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
        int endIndex = dest.lastIndexOf(File.separatorChar as String)
        dest = dest.substring(0, endIndex)
        File destFile = new File(dest)
        if (!destFile.exists()) {
            destFile.mkdir()
        }
        String cmd = "git clone " + gitAddr + " " + GitUtil.workSpace + remotePath
        cmd.execute().text
        destFile = new File(GitUtil.workSpace + remotePath)
        if (!destFile.exists()) {
            return AppConst.ERROR_INFO + GitUtil.workSpace + remotePath
        }
        GitUtil.workSpace + remotePath
    }

}
