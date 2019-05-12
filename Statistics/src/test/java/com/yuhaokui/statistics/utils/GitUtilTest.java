package com.yuhaokui.statistics.utils;

import com.yuhaokui.statistics.StatisticsApplication;
import com.yuhaokui.statistics.bean.ProjectCommit;
import com.yuhaokui.statistics.controller.CommitController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)     //调用Spring单元测试类
@WebAppConfiguration        //调用Java Web组件，如自动注入ServletContext Bean等
@SpringBootTest(classes = StatisticsApplication.class)
class GitUtilTest {

    @InjectMocks
    private CommitController commitController;

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void cloneTest() {
        GitUtil gitUtil = new GitUtil();
//        CommitController commitController = new CommitController();
        RequestBuilder request = MockMvcRequestBuilders.get("/getFinalCommit")
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        try {
            this.mockMvc.perform(request).andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        projects.forEach((commitInfo) -> {
//            gitUtil.clone(commitInfo.getGitPath());
//        });
    }
}