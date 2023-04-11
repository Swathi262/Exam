package com.cg.onlineassesment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineassesment.dao.CandidateDTO;
import com.cg.onlineassesment.exception.CandidateNotRegisteredException;
import com.cg.onlineassesment.service.CandidateService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	@Autowired
	public CandidateService candidateService;

	//http://localhost:9090/api/candidate/addCandidates
	@PostMapping("/addCandidates")
	public ResponseEntity<CandidateDTO> addCandidate(@Valid @RequestBody CandidateDTO candidates) {

		CandidateDTO savecandidate = candidateService.addCandidate(candidates);
		return ResponseEntity.ok(savecandidate);

	}

	@GetMapping("/fetchCandidateById/{id}")
	public ResponseEntity<CandidateDTO> getCandidateById(@PathVariable int id) {
		CandidateDTO candidateDTO = candidateService.getById(id);
		return new ResponseEntity<CandidateDTO>(candidateDTO, HttpStatus.FOUND);
	}

	@PutMapping("/updateCandidate")
	public ResponseEntity<CandidateDTO> updateCandidate(@RequestBody CandidateDTO candidateDTO) {
		return new ResponseEntity<CandidateDTO>(candidateService.updateCandidate(candidateDTO), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteCandidate/{id}")
	public ResponseEntity<Boolean> deleteCandidateById(@PathVariable int id) {
		CandidateDTO candidateDTO = candidateService.getById(id);
		if (candidateDTO != null) {
			candidateService.deleteCandidate(candidateDTO);
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		}
		throw new CandidateNotRegisteredException("Candidate doesn't Registered");
	}

	@GetMapping("/fetchAllCandidates")
	public ResponseEntity<List<CandidateDTO>> getAllCandidates() {
		List<CandidateDTO> list = candidateService.findAll();
		return ResponseEntity.ok(list);
	}

}
