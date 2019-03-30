package com.yuhaokui.statistics.utils

import org.springframework.beans.factory.annotation.Value

class GitUtil {

    String workSpace

    void clone(String gitAddr) {
        ("git clone " + gitAddr).execute()
    }
}
