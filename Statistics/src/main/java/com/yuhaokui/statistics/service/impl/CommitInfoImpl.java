package com.yuhaokui.statistics.service.impl;

import com.yuhaokui.statistics.bean.DateRegion;
import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.bean.UserCommit;
import com.yuhaokui.statistics.mapper.CommitMapper;
import com.yuhaokui.statistics.service.ICommitInfo;
import com.yuhaokui.statistics.utils.GitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CommitInfoImpl implements ICommitInfo {
    @Autowired
    CommitMapper commitMapper;

    @Override
    public List<ProjectCommit> getProjectCommits() {
        DateRegion dateRegion = new DateRegion();
        return commitMapper.getProjectCommitCounts(dateRegion.getBeginDate(), dateRegion.getEndDate());
    }

    @Override
    public List<UserCommit> getUserCommits() {
        DateRegion dateRegion = new DateRegion();
        return commitMapper.getUserCommitCounts(dateRegion.getBeginDate(), dateRegion.getEndDate());
    }

    @Override
    public List<ProjectCommit> getFinalCommits(int month) {
        DateRegion dateRegion;
        if (month == 0)
            dateRegion = new DateRegion();
        else
            dateRegion = new DateRegion(month);

        List<ProjectCommit> projectCommits = commitMapper.getProjectCommitCounts(dateRegion.getBeginDate(), dateRegion.getEndDate());
        List<UserCommit> userCommits = commitMapper.getUserCommitCounts(dateRegion.getBeginDate(), dateRegion.getEndDate());
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
            commitInfo.setGitPath(String.format("%s/%s/%s.git", GitUtil.getBaseUrl(), commitInfo.getGroupName(), commitInfo.getProjectPath()));
        });
        return projectCommits;
    }
}
