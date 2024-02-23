package com.kloc.atipera.responses;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private String repositoryName;
    private String ownerName;
    private final List<Branch> branches;

    public Repository(String repositoryName, String ownerName) {
        this.repositoryName = repositoryName;
        this.ownerName = ownerName;
        this.branches = new ArrayList<>();
    }

    public void addBranch(Branch branch){
        branches.add(branch);
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
