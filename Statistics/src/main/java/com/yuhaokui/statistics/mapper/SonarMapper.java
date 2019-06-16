package com.yuhaokui.statistics.mapper;

import com.yuhaokui.statistics.bean.SonarProject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SonarMapper {
    List<SonarProject> getSonarProject();
}
