package com.yuhaokui.statistics.service.impl;

import com.yuhaokui.statistics.bean.ProjectCommit;
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
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        int firstDay = cal.getMinimum(Calendar.DATE);
        cal.set(Calendar.DAY_OF_MONTH,firstDay);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String beginDate = sdf.format(cal.getTime());
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        String endDate = sdf.format(cal.getTime());
        return commitMapper.getProjectCommitCounts(beginDate, endDate);
    }
}
