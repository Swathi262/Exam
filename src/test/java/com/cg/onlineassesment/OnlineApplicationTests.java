package com.cg.onlineassesment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.onlineassesment.dao.CandidateDTO;
import com.cg.onlineassesment.entity.Candidate;
import com.cg.onlineassesment.repository.CandidateRepository;
import com.cg.onlineassesment.service.CandidateService;
import com.cg.onlineassesment.serviceimpl.CandidateServiceImpl;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class OnlineApplicationTests {
  //@Autowired
 @Mock
 private CandidateRepository candidaterepository;
 
  @InjectMocks
  private CandidateServiceImpl candidateServiceImpl;
  
  private CandidateDTO candidateDto;
  
 
  @Before
  public void setUp() {
	  candidateDto= new CandidateDTO();
	  candidateDto.setCustid(1);
	  candidateDto.setEmail("max@12.gmail.com");
	  candidateDto.setName("Max");
	  candidateDto.setQualification("PHD");
	  


  }
  @Test
  public void testAddCandidates() {
	  Candidate candidate=new Candidate();
	  candidate.setCustid(candidateDto.getCustid());
	  candidate.setEmail(candidateDto.getEmail());
	  candidate.setName(candidateDto.getName());
	  candidate.setQualification(candidateDto.getQualification());
	  
	  when(candidaterepository.save(candidate)).thenReturn(candidate);
	  CandidateDTO result=candidateServiceImpl.addCandidate(candidateDto);
	  assertEquals(candidateDto, result);
	  
	  
  }

  

//  @Test
//  public void getCandidateTest() {
//	  when(repository.findAll()).thenReturn(Stream.of(new Candidate("Max"), new Candidate("Maxine")).collect(Collectors.toList()));
//	  assertEquals(2, service.addCandidate(null).getName());
//	  
//	  
//  }
  
//  @Test
//  public void addCandidateTest() {
//	  CandidateDTO candidate=new CandidateDTO(5,"abc@gamil.com",798739748,"abc","abc@168","BTech",12);
//	  when(repository.save(candidate).thenReturn(candidate));
//	  assertEquals(candidate, service.addCandidate(candidate));
//	  
//  }
	
	
}
