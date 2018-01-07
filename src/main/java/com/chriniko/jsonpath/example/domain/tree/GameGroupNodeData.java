package com.chriniko.jsonpath.example.domain.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameGroupNodeData {

    private String groupId;
    private String primaryGame;
    private boolean disallowProvidedDrawWagering;
    private boolean isMandatory;
    private Map<String, String> games;
}
