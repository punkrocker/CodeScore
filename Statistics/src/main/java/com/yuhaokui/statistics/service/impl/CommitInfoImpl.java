package com.yuhaokui.statistics.service.impl;

import com.yuhaokui.statistics.bean.DateRegion;
import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.bean.UserCommit;
import com.yuhaokui.statistics.mapper.CommitMapper;
import com.yuhaokui.statistics.service.ICommitInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    public List<ProjectCommit> getFinalCommits() {
        DateRegion dateRegion = new DateRegion();
        return null;
    }
}
