package com.yuhaokui.statistics.utils

import org.springframework.beans.factory.annotation.Value

class GitUtil {

    @Value('${git.workspace}')
    String workSpace
}
