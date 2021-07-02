package com.demo.neo4j.repository;

import com.demo.neo4j.entity.PersonRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRelationshipRepository extends Neo4jRepository<PersonRelationship, Long> {
}
