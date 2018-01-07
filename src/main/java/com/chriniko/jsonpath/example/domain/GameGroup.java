package com.chriniko.jsonpath.example.domain;

import com.chriniko.jsonpath.example.domain.common.DbgEntity;
import com.chriniko.jsonpath.example.domain.tree.GameGroupTree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class to represent Lottery Game group
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameGroup extends DbgEntity {

    private String rootGroupId;

    private GameGroupTree tree;

    private String transactionId;

}
