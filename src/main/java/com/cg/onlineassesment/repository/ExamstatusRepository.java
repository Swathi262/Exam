package com.cg.onlineassesment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineassesment.entity.Examstatus;

@Repository
public interface ExamstatusRepository extends CrudRepository<Examstatus, Integer> {
	Iterable<Examstatus> findAll();
}
