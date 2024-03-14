package com.kloc.gitmicroservice.models;

public record Branch(
        String name,
        Commit commit
){}