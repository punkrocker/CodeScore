package com.yuhaokui.statistics.utils;

import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.service.impl.CommitInfoImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
@ComponentScan(basePackages = "com.yuhaokui.statistics.*")
@PropertySource({
        "classpath:application-pro.properties"
})
class GitUtilTest {

    @Autowired
    CommitInfoImpl commitInfos;

    @Test
    void cloneTest() {
        GitUtil gitUtil = new GitUtil();
        List<ProjectCommit> projectCommits = commitInfos.getFinalCommits(0);
        projectCommits.forEach((commitInfo) -> {
            System.out.println(gitUtil.clone(commitInfo.getGitPath()));
        });
    }
}