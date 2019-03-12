package com.yuhaokui.statistics.controller;

import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.bean.UserCommit;
import com.yuhaokui.statistics.mapper.CommitMapper;
import com.yuhaokui.statistics.service.impl.CommitInfoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommitController {
    @Autowired
    private CommitInfoImpl commitInfo;

    @RequestMapping("/getProjectCommits")
    public List<ProjectCommit> getProjectCommits() {
        return commitInfo.getProjectCommits();
    }

    @RequestMapping("/getUserCommits")
    public List<UserCommit> getUserCommits() {
        return commitInfo.getUserCommits();
    }
}
