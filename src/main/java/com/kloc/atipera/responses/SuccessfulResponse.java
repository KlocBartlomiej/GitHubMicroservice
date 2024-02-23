package com.kloc.atipera.responses;

import com.kloc.atipera.models.Repository;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class SuccessfulResponse implements Response{
    @Getter
    private final List<Repository> repositories;

    public SuccessfulResponse() {
        this.repositories = new ArrayList<>();
    }

    public void addRepository(Repository repo){
        repositories.add(repo);
    }
}
