package com.yuhaokui.statistics.bean

class ProjectCommit {
    Integer id
    String groupName
    String projectPath
    Integer commitCount
    List<UserCommit> userCommits

    ProjectCommit() {
        userCommits = new ArrayList<>()
    }
}
