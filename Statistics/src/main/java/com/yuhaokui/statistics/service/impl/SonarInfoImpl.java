package com.yuhaokui.statistics.service.impl;

import com.yuhaokui.statistics.bean.SonarProject;
import com.yuhaokui.statistics.mapper.SonarMapper;
import com.yuhaokui.statistics.service.ISonarInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SonarInfoImpl implements ISonarInfo {
    @Autowired
    SonarMapper sonarMapper;

    @Override
    public List<SonarProject> getSonarProjects() {
        return sonarMapper.getSonarProject();
    }
}
