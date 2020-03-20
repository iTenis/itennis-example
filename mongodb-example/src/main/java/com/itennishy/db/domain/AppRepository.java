package com.itennishy.db.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends MongoRepository<App, String> {
}
