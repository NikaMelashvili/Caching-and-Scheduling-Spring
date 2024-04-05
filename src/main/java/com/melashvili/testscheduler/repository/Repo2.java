package com.melashvili.testscheduler.repository;

import com.melashvili.testscheduler.model.MoreStudents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo2 extends CrudRepository<MoreStudents, Integer> {
}
