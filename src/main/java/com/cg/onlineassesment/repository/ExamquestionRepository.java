package com.cg.onlineassesment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineassesment.entity.Examquestion;

@Repository
public interface ExamquestionRepository extends CrudRepository<Examquestion, Integer> {
	Iterable<Examquestion> findAll();	
}
