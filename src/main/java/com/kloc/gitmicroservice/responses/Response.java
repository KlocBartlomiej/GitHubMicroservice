package com.kloc.gitmicroservice.responses;

import com.kloc.gitmicroservice.models.Branch;

import java.util.List;

public record Response(
        String repositoryName,
        String userName,
        List<Branch>branches
){}
