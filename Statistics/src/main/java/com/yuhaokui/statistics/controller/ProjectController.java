package com.yuhaokui.statistics.controller;

import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.bean.SonarProject;
import com.yuhaokui.statistics.service.impl.CommitInfoImpl;
import com.yuhaokui.statistics.service.impl.SonarInfoImpl;
import com.yuhaokui.statistics.utils.AppConst;
import com.yuhaokui.statistics.utils.GitUtil;
import com.yuhaokui.statistics.utils.SonarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    CommitInfoImpl commitInfos;

    @Autowired
    SonarInfoImpl sonarInfo;

    @RequestMapping("/git")
    public String index(@RequestParam(value = "month", defaultValue = "0") int month) {
        GitUtil gitUtil = new GitUtil();
        gitUtil.cleanWorkSpace();
        SonarUtil sonarUtil = new SonarUtil();
        List<ProjectCommit> projectCommits = commitInfos.getFinalCommits(month);
        projectCommits.forEach((commitInfo) -> {
            String workPath = gitUtil.clone(commitInfo.getGitPath());
            if (!workPath.startsWith(AppConst.ERROR_INFO))
                sonarUtil.checkConfigFile(workPath);
        });
        return String.valueOf(projectCommits.size());
    }

    @RequestMapping("/scan")
    public String scan() {
        return "success";
    }

    @RequestMapping("/sonar")
    public List<SonarProject> hi() {
        return sonarInfo.getSonarProjects();
    }
}
