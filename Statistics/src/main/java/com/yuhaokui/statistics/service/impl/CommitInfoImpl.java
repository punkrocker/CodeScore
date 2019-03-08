package com.yuhaokui.statistics.service.impl;

import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.mapper.CommitMapper;
import com.yuhaokui.statistics.service.ICommitInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitInfoImpl implements ICommitInfo {
    @Autowired
    CommitMapper commitMapper;

    @Override
    public List<ProjectCommit> getProjectCommits() {
        return commitMapper.getProjectCommitCounts();
    }
}
