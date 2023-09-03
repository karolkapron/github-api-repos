package com.example.github.Model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "github", url = "https://api.github.com")
public interface GitHubClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users/{username}/repos")
    List<RepoDto> listRepos(@PathVariable("username") String username);

    @RequestMapping(method = RequestMethod.GET, value = "/repos/{owner}/{repo}/branches")
    List<BranchDto> listBranches(@PathVariable("owner") String owner, @PathVariable("repo") String repoName);
}


