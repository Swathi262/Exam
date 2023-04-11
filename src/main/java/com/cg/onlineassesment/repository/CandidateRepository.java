package com.cg.onlineassesment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineassesment.entity.Candidate;


@Repository

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
	Iterable<Candidate> findAll();

}
