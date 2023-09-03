package com.example.github;

import com.example.github.Model.GitHubClient;
import com.example.github.Model.RepoDto;
import com.example.github.Service.GitHubService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GitHubServiceTest {

    @Mock
    private GitHubClient gitHubClient;

    @InjectMocks
    private GitHubService gitHubService;

    @Test
    public void testListUserRepos() {
        List<RepoDto> mockRepos = new ArrayList<>();
        mockRepos.add(new RepoDto("repo1", "user1", false));
        mockRepos.add(new RepoDto("repo2", "user1", true));
        when(gitHubClient.listRepos("user1")).thenReturn(mockRepos);

        List<RepoDto> result = gitHubService.listRepos("user1");

        assert(result.size() ==1);
        assert (result.get(0).getName().equals("repo1"));
        assert(result.get(0).getUsername().equals("user1"));
        assert(!result.get(0).isFork());
    }
}
