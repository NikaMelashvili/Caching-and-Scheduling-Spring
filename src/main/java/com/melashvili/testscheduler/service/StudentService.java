package com.melashvili.testscheduler.service;

import com.melashvili.testscheduler.model.MoreStudents;
import com.melashvili.testscheduler.model.Student;
import com.melashvili.testscheduler.repository.Repo;
import com.melashvili.testscheduler.repository.Repo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private Repo repo;

    @Autowired
    private Repo2 repo2;

    @Autowired
    private CacheManager cacheManager;

    public List<String> cacheNames = new ArrayList<>();

    @Cacheable(value = "getAllStudents")
    public List<Student> getAll(){
        Iterable<Student> studentIterable = repo.findAll();
        List<Student> students = new ArrayList<>();

        for (Student student : studentIterable) {
            students.add(student);
        }

        return students;
    }

    @Cacheable(value = "getAllStudents_2")
    public List<MoreStudents> getMoreAll(){
        Iterable<MoreStudents> studentIterable = repo2.findAll();
        List<MoreStudents> students = new ArrayList<>();

        for (MoreStudents student : studentIterable) {
            students.add(student);
        }

        return students;
    }

    public void addCacheNamesToList() {
        cacheManager.getCacheNames().forEach(cacheNames::add);
    }

    public void evictAllCaches() {
        cacheManager.getCacheNames().stream()
                .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }

    int i = 0;
    @Scheduled(fixedRate = 5000)
    public void evictAllCachesAtIntervals() {
        addCacheNamesToList();
        evictAllCaches();
        System.out.println(i++);
    }

    public List<String> getCacheNames() {
        return cacheNames;
    }
}

