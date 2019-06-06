package com.yuhaokui.statistics.controller;

import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.service.impl.CommitInfoImpl;
import com.yuhaokui.statistics.utils.AppConst;
import com.yuhaokui.statistics.utils.GitUtil;
import com.yuhaokui.statistics.utils.SonarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/git")
public class GitController {
    @Autowired
    CommitInfoImpl commitInfos;

    @RequestMapping("/")
    public String index() {
        GitUtil gitUtil = new GitUtil();
        SonarUtil sonarUtil = new SonarUtil();
        List<ProjectCommit> projectCommits = commitInfos.getFinalCommits();
        projectCommits.forEach((commitInfo) -> {
            String workPath = gitUtil.clone(commitInfo.getGitPath());
            if (!workPath.startsWith(AppConst.ERROR_INFO))
                System.out.println(sonarUtil.checkConfigFile(workPath));
        });
        return "success";
    }
}
