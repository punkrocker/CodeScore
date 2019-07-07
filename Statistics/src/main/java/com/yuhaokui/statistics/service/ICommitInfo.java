package com.yuhaokui.statistics.service;

import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.bean.UserCommit;

import java.util.List;

public interface ICommitInfo {
    List<ProjectCommit> getProjectCommits();
    List<UserCommit> getUserCommits();
    List<ProjectCommit> getFinalCommits(int month);
}
