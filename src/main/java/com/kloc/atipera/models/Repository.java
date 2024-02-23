package com.kloc.atipera.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    @Getter
    @Setter
    private String repositoryName;
    @Getter
    @Setter
    private String ownerName;
    @Getter
    private final List<Branch> branches;

    public Repository(String repositoryName, String ownerName) {
        this.repositoryName = repositoryName;
        this.ownerName = ownerName;
        this.branches = new ArrayList<>();
    }

    public void addBranch(Branch branch){
        branches.add(branch);
    }
}
