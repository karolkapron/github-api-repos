package com.example.github.Model;

public class BranchDto {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommitDto getCommit() {
        return commit;
    }

    public void setCommit(CommitDto commit) {
        this.commit = commit;
    }

    public String name;
    public CommitDto commit;
}
