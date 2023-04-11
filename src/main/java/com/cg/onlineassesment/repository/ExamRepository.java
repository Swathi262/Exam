package com.cg.onlineassesment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineassesment.entity.Exam;

@Repository
public interface ExamRepository extends CrudRepository<Exam, Integer> {

}
