package com.yuhaokui.statistics.mapper;

import com.yuhaokui.statistics.bean.ProjectCommit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommitMapper {
    List<ProjectCommit> getProjectCommitCounts();
}