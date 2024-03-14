package com.kloc.gitmicroservice.controller;

import com.kloc.gitmicroservice.responses.Response;
import com.kloc.gitmicroservice.service.GitHubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/{user}")
    public List<Response> getUserRepos(@PathVariable(value="user") String user){
        return gitHubService.getResponse(user);
    }
}
