package com.yuhaokui.statistics.service;

import com.yuhaokui.statistics.bean.SonarProject;

import java.util.List;

public interface ISonarInfo {
    List<SonarProject> getSonarProjects();
}
