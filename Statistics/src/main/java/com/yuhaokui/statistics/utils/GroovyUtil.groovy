package com.yuhaokui.statistics.utils

class GroovyUtil {
    String runCommand(String cmd) {
        cmd.execute().text
    }
}
