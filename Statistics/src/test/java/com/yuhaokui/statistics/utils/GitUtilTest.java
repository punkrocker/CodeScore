package com.yuhaokui.statistics.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GitUtilTest {

    @Test
    void cloneTest() {
        GitUtil gitUtil = new GitUtil();
        System.out.println(gitUtil.clone("http://tmember:123123123@localhost:8000/yuhaokui/testproject2.git"));
    }
}