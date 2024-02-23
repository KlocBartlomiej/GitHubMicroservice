package com.kloc.atipera.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Branch {
    @Getter
    @Setter
    private String branchName;
    @Getter
    @Setter
    private String lastCommitSha;

    public Branch(String branchName, String lastCommitSha) {
        this.branchName = branchName;
        this.lastCommitSha = lastCommitSha;
    }
}
