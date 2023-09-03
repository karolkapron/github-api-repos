package com.example.github.Controller;

import com.example.github.Model.GitHubClient;
import com.example.github.Model.RepoDto;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GitHubController {

    @Autowired
    private GitHubClient githubClient;

    @GetMapping("/repos/{username}")
    public ResponseEntity<?> listRepos(@PathVariable String username, @RequestHeader("Accept") String acceptHeader) {
        if (!"application/json".equals(acceptHeader)) {
            return ResponseEntity.status(406).body(Map.of("status", 406, "Message", "Only application/json is supported"));
        }

        try {
            List<RepoDto> repos = githubClient.listRepos(username);
            List<RepoDto> nonForkRepos = repos.stream().filter(r -> !r.isFork()).collect(Collectors.toList());

            for (RepoDto repo : nonForkRepos) {
                repo.branches = githubClient.listBranches(username, repo.getName());
            }

            return ResponseEntity.ok(nonForkRepos);

        } catch (FeignException.NotFound e) {
            return ResponseEntity.status(404).body(Map.of("status", 404, "Message", "User not found"));
        }
    }
}
