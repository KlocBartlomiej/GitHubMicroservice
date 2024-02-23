package com.kloc.atipera.responses;

import java.util.ArrayList;
import java.util.List;

public class SuccessfulResponse implements Response{
    private final List<Repository> repositories;

    public SuccessfulResponse() {
        this.repositories = new ArrayList<>();
    }

    public void addRepository(Repository repo){
        repositories.add(repo);
    }

    public List<Repository> getRepositories() {
        return repositories;
    }
}
