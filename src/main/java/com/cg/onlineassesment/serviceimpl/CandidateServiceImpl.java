package com.cg.onlineassesment.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineassesment.dao.CandidateDTO;
import com.cg.onlineassesment.entity.Candidate;
import com.cg.onlineassesment.repository.CandidateRepository;
import com.cg.onlineassesment.service.CandidateService;




@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	private CandidateRepository candidateRepository;
	@Override
	public CandidateDTO addCandidate(CandidateDTO candidateDto) {
		// TODO Auto-generated method stub
		Candidate candidate = new Candidate();
		candidate.setEmail(candidateDto.getEmail());
		candidate.setMobileno(candidateDto.getMobileno());
		candidate.setName(candidateDto.getName());
		candidate.setCustid(candidateDto.getCustid());
		candidate.setQualification(candidateDto.getQualification());
		candidate.setPassword(candidateDto.getPassword());
		Candidate candidatesave =candidateRepository.save(candidate);
		candidateDto.setCustid(candidatesave.getCustid());
	
		return candidateDto;
		
	}

	@Override
	public CandidateDTO updateCandidate(CandidateDTO candidateDTO) {
		// TODO Auto-generated method stub
        Candidate candidate = new Candidate();
		
		candidate.setCustid(candidateDTO.getCustid());
		candidate.setQualification(candidateDTO.getQualification());
		candidate.setPassword(candidateDTO.getPassword());
		candidate.setEmail(candidateDTO.getEmail());
		candidate.setMobileno(candidateDTO.getMobileno());
		candidate.setName(candidateDTO.getName());		
		Candidate saveId=candidateRepository.save(candidate);
		candidateDTO.setCustid(saveId.getCustid());
		
		return candidateDTO;
	}

	@Override
	public boolean deleteCandidate(CandidateDTO candidateDTO) {
		// TODO Auto-generated method stub
		Candidate candidate = new Candidate();
		candidate.setCustid(candidateDTO.getCustid());
		candidateRepository.delete(candidate);
		return true;
	}

	@Override
	public CandidateDTO getById(int id) {
		// TODO Auto-generated method stub
		Optional<Candidate> candidate = candidateRepository.findById(id);
		if (candidate.isPresent()) {
			CandidateDTO dto = new CandidateDTO();
			BeanUtils.copyProperties(candidate.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<CandidateDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<Candidate> candidate = candidateRepository.findAll();
		List<CandidateDTO> dtos = new ArrayList<>();
		for (Candidate candidates : candidate) {
			CandidateDTO dto = new CandidateDTO();
			BeanUtils.copyProperties(candidate, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}
