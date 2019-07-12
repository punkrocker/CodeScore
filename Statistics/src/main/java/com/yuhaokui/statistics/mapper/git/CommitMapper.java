package com.yuhaokui.statistics.mapper.git;

import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.bean.UserCommit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommitMapper {
    List<ProjectCommit> getProjectCommitCounts(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

    List<UserCommit> getUserCommitCounts(@Param("beginDate") String beginDate, @Param("endDate") String endDate);
}
