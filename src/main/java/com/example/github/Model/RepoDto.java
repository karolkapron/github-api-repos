package com.example.github.Model;


import java.util.List;
import java.util.Objects;

public class RepoDto {

    public List<BranchDto> branches;

    private String name;
    private String username;
    private boolean fork;

    public RepoDto(String name, String username, boolean fork) {
        this.name = name;
        this.username = username;
        this.fork = fork;
    }

    public boolean isEqualTo(String name){
        if(Objects.equals(this.name, name)){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }


    public String getUsername() {
        return username;
    }


    public boolean isFork() {
        return fork;
    }

}
