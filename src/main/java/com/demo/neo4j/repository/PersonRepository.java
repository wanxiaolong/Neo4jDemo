package com.demo.neo4j.repository;

import com.demo.neo4j.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {
    @Query("match(a:Person {name:$name})-[r:MARRIED *..1]->(b:Person) return b")
    Person findTA(@Param("name") String name);

    @Query("MATCH (a:Person {name:$name})-[r1:FRIENDS *..1]->(b:Person)-" +
            "[r2:FRIENDS]->(c:Person) RETURN c")
    List<Person> findFriendsOfFriends(@Param("name") String name);
}
