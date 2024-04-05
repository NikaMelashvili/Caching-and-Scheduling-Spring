package com.melashvili.testscheduler.repository;

import com.melashvili.testscheduler.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends CrudRepository<Student, Integer> {
}
