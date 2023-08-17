package com.tpe.repository;

import com.tpe.domain.AppLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<AppLog,String> {
}
