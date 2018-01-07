package com.chriniko.jsonpath.example.dao;

import com.chriniko.jsonpath.example.domain.GameGroup;

public interface GameGroupDao {

    GameGroup findGameGroup(String groupName);

    String findGameGroupTreeAsString(String groupName);
}
