package com.chriniko.jsonpath.example.service;

public interface GameGroupExtractor {

    boolean isPrimaryGame(String groupName, String gameId);

    boolean isPrimaryGame_Hard(String groupName, String gameId);
}
