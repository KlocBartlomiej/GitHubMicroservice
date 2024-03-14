package com.kloc.gitmicroservice.service;

import com.kloc.gitmicroservice.models.Branch;
import com.kloc.gitmicroservice.models.Repository;
import com.kloc.gitmicroservice.responses.Response;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class GitHubService {

    private final RestClient restClient;

    public GitHubService(RestClient restClient) {
        this.restClient = RestClient.builder()
                .baseUrl("${github.base-url}")
                .build();
    }

    public List<Response> getResponse(String user){
        return getAllRepositories(user).stream()
                .filter(repository -> !repository.fork())
                .map(repository -> new Response(
                        repository.name(),
                        user,
                        getAllBranches(user,repository.name())
                ))
                .toList();
    }

    public List<Repository> getAllRepositories(String user){
        return restClient.get()
                .uri("/users/" + user + "/repos")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    //throw new RepositoryNotFoundException(response);
                })
                .body(new ParameterizedTypeReference<List<Repository>>() {});
    }

    public List<Branch> getAllBranches(String user, String repositoryName){
        return restClient.get()
                .uri("/repos/" + user + "/" + repositoryName + "/branches")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    //throw new BranchesNotFoundException(response);
                })
                .body(new ParameterizedTypeReference<List<Branch>>() {});
    }
}
