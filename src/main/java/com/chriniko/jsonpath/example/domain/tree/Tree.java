package com.chriniko.jsonpath.example.domain.tree;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")

@JsonSubTypes({
        @JsonSubTypes.Type(value = GameGroupTree.class, name = "GameGroupTree")
})

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tree<T> {

    private Set<Tree<T>> children;
    private T data;
    private String type;

}
