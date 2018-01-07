package com.chriniko.jsonpath.example.dao;

import com.chriniko.jsonpath.example.domain.GameGroup;
import com.chriniko.jsonpath.example.domain.tree.GameGroupTree;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Repository
public class GameGroupDaoImpl implements GameGroupDao {

    private static final Map<String, Supplier<String>> GAME_GROUPS_DB;

    static {

        GAME_GROUPS_DB = new HashMap<>();

        GAME_GROUPS_DB.put("EuromillionsFamily", GameGroupDaoImpl::getEuromillionsFamilyTree);
        GAME_GROUPS_DB.put("LottoFamily", GameGroupDaoImpl::getLottoFamilyTree);
        GAME_GROUPS_DB.put("LoexFamily", GameGroupDaoImpl::getLoexFamilyTree);
    }

    private final ObjectMapper objectMapper;

    @Autowired
    public GameGroupDaoImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public GameGroup findGameGroup(String groupName) {

        return Optional
                .ofNullable(GAME_GROUPS_DB.get(groupName).get())
                .map(groupGameTree -> {
                    GameGroupTree gameGroupTree = getGameGroupTree(groupGameTree);
                    return new GameGroup(groupName, gameGroupTree, UUID.randomUUID().toString());
                })
                .orElseThrow(() -> new IllegalStateException("Provided groupName does not exist in db."));
    }

    @Override
    public String findGameGroupTreeAsString(String groupName) {
        return Optional
                .ofNullable(GAME_GROUPS_DB.get(groupName).get())
                .orElseThrow(() -> new IllegalStateException("Provided groupName does not exist in db."));
    }

    private GameGroupTree getGameGroupTree(String groupGameTree) {
        try {
            return objectMapper.readValue(groupGameTree, GameGroupTree.class);
        } catch (IOException e) {
            throw new IllegalStateException("Could not deserialize db info.");
        }
    }

    private static String getEuromillionsFamilyTree() {
        return "{\n" +
                "  \"type\": \"GameGroupTree\",\n" +
                "  \"children\": [\n" +
                "    {\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"children\": [\n" +
                "        \n" +
                "      ],\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"data\": {\n" +
                "        \"groupId\": \"EuromillionsSubFamily\",\n" +
                "        \"primaryGame\": \"euromillions\",\n" +
                "        \"disallowProvidedDrawWagering\": false,\n" +
                "        \"games\": {\n" +
                "          \"euromillions\": null,\n" +
                "          \"swisswin\": \"euromillions\",\n" +
                "          \"raffle\": null\n" +
                "        },\n" +
                "        \"mandatory\": false\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"children\": [\n" +
                "        \n" +
                "      ],\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"data\": {\n" +
                "        \"groupId\": \"SuperstarFamily\",\n" +
                "        \"disallowProvidedDrawWagering\": true,\n" +
                "        \"games\": {\n" +
                "          \"superstar\": null\n" +
                "        },\n" +
                "        \"mandatory\": false\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"type\": \"GameGroupTree\",\n" +
                "  \"data\": {\n" +
                "    \"groupId\": \"EuromillionsFamily\",\n" +
                "    \"disallowProvidedDrawWagering\": false,\n" +
                "    \"games\": {\n" +
                "      \n" +
                "    },\n" +
                "    \"mandatory\": true\n" +
                "  }\n" +
                "}";
    }

    private static String getLottoFamilyTree() {
        return "{\n" +
                "  \"type\": \"GameGroupTree\",\n" +
                "  \"children\": [\n" +
                "    {\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"children\": [\n" +
                "        \n" +
                "      ],\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"data\": {\n" +
                "        \"groupId\": \"SwissLottoFamily\",\n" +
                "        \"primaryGame\": \"swisslotto\",\n" +
                "        \"disallowProvidedDrawWagering\": false,\n" +
                "        \"games\": {\n" +
                "          \"swisslotto\": null,\n" +
                "          \"replay\": null\n" +
                "        },\n" +
                "        \"mandatory\": false\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"children\": [\n" +
                "        \n" +
                "      ],\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"data\": {\n" +
                "        \"groupId\": \"JokerFamily\",\n" +
                "        \"primaryGame\": \"joker\",\n" +
                "        \"disallowProvidedDrawWagering\": false,\n" +
                "        \"games\": {\n" +
                "          \"joker\": null\n" +
                "        },\n" +
                "        \"mandatory\": false\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"type\": \"GameGroupTree\",\n" +
                "  \"data\": {\n" +
                "    \"groupId\": \"LottoFamily\",\n" +
                "    \"disallowProvidedDrawWagering\": false,\n" +
                "    \"games\": {\n" +
                "      \n" +
                "    },\n" +
                "    \"mandatory\": true\n" +
                "  }\n" +
                "}";
    }

    private static String getLoexFamilyTree() {
        return "{\n" +
                "  \"type\": \"GameGroupTree\",\n" +
                "  \"children\": [\n" +
                "    {\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"children\": [\n" +
                "        \n" +
                "      ],\n" +
                "      \"type\": \"GameGroupTree\",\n" +
                "      \"data\": {\n" +
                "        \"groupId\": \"LoexExtraFamily\",\n" +
                "        \"disallowProvidedDrawWagering\": false,\n" +
                "        \"games\": {\n" +
                "          \"lorolottoexpressextra\": \"lorolottoexpress\"\n" +
                "        },\n" +
                "        \"mandatory\": false\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"type\": \"GameGroupTree\",\n" +
                "  \"data\": {\n" +
                "    \"groupId\": \"LoexFamily\",\n" +
                "    \"primaryGame\": \"lorolottoexpress\",\n" +
                "    \"disallowProvidedDrawWagering\": false,\n" +
                "    \"games\": {\n" +
                "      \"lorolottoexpress\": null\n" +
                "    },\n" +
                "    \"mandatory\": true\n" +
                "  }\n" +
                "}";
    }
}
