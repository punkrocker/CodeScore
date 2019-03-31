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

    void clone(String gitAddr) {
        ("git clone " + gitAddr).execute()
    }
}
