package com.yuhaokui.statistics.controller;

import com.yuhaokui.statistics.utils.GitUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git")
public class GitController {

    @RequestMapping("/")
    public String index() {
        GitUtil gitUtil = new GitUtil();
        return gitUtil.clone("yuhaokui/testproject2");
    }
}
