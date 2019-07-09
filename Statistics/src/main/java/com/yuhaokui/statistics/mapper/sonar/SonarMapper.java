package com.yuhaokui.statistics.mapper.sonar;

import com.yuhaokui.statistics.bean.SonarProject;
import com.yuhaokui.statistics.bean.SonarResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Qualifier("sonarTemplate")
public interface SonarMapper {
    List<SonarProject> getSonarProject();
    List<SonarResult> getSonarResult();
}
