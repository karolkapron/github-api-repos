package com.example.github.Service;

import com.example.github.Model.GitHubClient;
import com.example.github.Model.RepoDto;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubService {
    private final GitHubClient gitHubClient;

    @Autowired
    public GitHubService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    public List<RepoDto> listRepos(String username) {
        return gitHubClient.listRepos(username)
                .stream()
                .filter(repo -> !repo.isFork())
                .collect(Collectors.toList());
    }
}

