package com.cg.onlineassesment.service;

import java.util.List;

import com.cg.onlineassesment.dao.CandidateDTO;



public interface CandidateService {
public CandidateDTO addCandidate(CandidateDTO candidate);
	
	public CandidateDTO updateCandidate(CandidateDTO candidateDTO);
	
	public boolean deleteCandidate(CandidateDTO candidateDTO);
	
	public CandidateDTO getById( int id);
	
	public List<CandidateDTO> findAll();

}
