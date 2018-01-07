package com.chriniko.jsonpath.example.service;

import com.chriniko.jsonpath.example.dao.GameGroupDao;
import com.chriniko.jsonpath.example.domain.GameGroup;
import com.chriniko.jsonpath.example.domain.tree.GameGroupNodeData;
import com.chriniko.jsonpath.example.domain.tree.Tree;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameGroupExtractorImpl implements GameGroupExtractor {

    private static final String PRIMARY_GAME_JSON_PATH = "$..primaryGame";

    private final GameGroupDao gameGroupDao;

    @Autowired
    public GameGroupExtractorImpl(GameGroupDao gameGroupDao) {
        this.gameGroupDao = gameGroupDao;
    }

    @Override
    public boolean isPrimaryGame(String groupName, String gameId) {

        String gameGroupTreeAsString = gameGroupDao.findGameGroupTreeAsString(groupName);

        List<String> includedPrimaryGameIds = JsonPath.read(gameGroupTreeAsString, PRIMARY_GAME_JSON_PATH);

        return includedPrimaryGameIds.contains(gameId);
    }

    @Override
    public boolean isPrimaryGame_Hard(String groupName, String gameId) {

        GameGroup gameGroup = gameGroupDao.findGameGroup(groupName);

        Tree<GameGroupNodeData> rootGameGroupTree = gameGroup.getTree();

        return processNode(rootGameGroupTree, gameId);

    }

    private boolean processNode(Tree<GameGroupNodeData> gameGroupTreeNode, String gameId) {

        if (gameGroupTreeNode.getData() != null
                && gameGroupTreeNode.getData().getPrimaryGame() != null
                && gameGroupTreeNode.getData().getPrimaryGame().equals(gameId)) {
            return true;
        }

        if (gameGroupTreeNode.getChildren() == null || gameGroupTreeNode.getChildren().isEmpty()) {
            return false;
        }

        for (Tree<GameGroupNodeData> gameGroupNodeDataTree : gameGroupTreeNode.getChildren()) {

            boolean result = processNode(gameGroupNodeDataTree, gameId);
            if (result) {
                return true;
            }

        }

        return false;
    }

}
