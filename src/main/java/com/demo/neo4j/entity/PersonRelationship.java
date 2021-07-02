package com.demo.neo4j.entity;

import com.demo.neo4j.enums.RelationshipType;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class PersonRelationship {

    @Id
    @GeneratedValue
    private Long id;

    private RelationshipType relationshipType;

    private Person from;

    private Person to;
}
