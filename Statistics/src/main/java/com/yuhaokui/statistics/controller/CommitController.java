package com.yuhaokui.statistics.controller;

import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.bean.UserCommit;
import com.yuhaokui.statistics.mapper.CommitMapper;
import com.yuhaokui.statistics.service.impl.CommitInfoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CommitController {
    @Autowired
    private CommitInfoImpl commitInfo;

    @Value("${git.baseurl}")
    private String baseUrl;

    @RequestMapping("/getProjectCommits")
    public List<ProjectCommit> getProjectCommits() {
        return commitInfo.getProjectCommits();
    }

    @RequestMapping("/getUserCommits")
    public List<UserCommit> getUserCommits() {
        return commitInfo.getUserCommits();
    }

    @RequestMapping("/getFinalCommit")
    public List<ProjectCommit> getFinalCommits() {
        List<ProjectCommit> projectCommits = commitInfo.getProjectCommits();
        List<UserCommit> userCommits = commitInfo.getUserCommits();
        HashMap<Integer, ProjectCommit> projectMap = new HashMap<>();
        for (ProjectCommit projectCommit :
                projectCommits) {
            projectMap.put(projectCommit.getId(), projectCommit);
        }
        for (UserCommit userCommit : userCommits) {
            ProjectCommit selectedProjectCommit = projectMap.get(userCommit.getProjectId());
            userCommit.setPercent(userCommit.getCommitCount() * 1.0f / selectedProjectCommit.getCommitCount());
            selectedProjectCommit.getUserCommits().add(userCommit);
        }
        projectCommits.forEach((commitInfo) -> {
            commitInfo.setGitPath(String.format("%s/%s/%s.git", baseUrl, commitInfo.getGroupName(), commitInfo.getProjectPath()));
        });
        return projectCommits;
    }
}
