package com.yuhaokui.statistics.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GitUtilTest {

    @Test
    void cloneTest() {
        GitUtil gitUtil = new GitUtil();
        System.out.println(gitUtil.clone("http://211.medicalai.net:8012/Gauge/ScaleReact.git"));
    }
}