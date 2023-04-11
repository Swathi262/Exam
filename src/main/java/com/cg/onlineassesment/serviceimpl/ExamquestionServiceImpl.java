package com.cg.onlineassesment.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineassesment.dao.ExamquestionDTO;
import com.cg.onlineassesment.entity.Examquestion;
import com.cg.onlineassesment.repository.ExamquestionRepository;
import com.cg.onlineassesment.service.ExamquestionService;

@Service
public class ExamquestionServiceImpl implements ExamquestionService {
	@Autowired
	private ExamquestionRepository examquestionrepository;
	@Override
	public ExamquestionDTO addExamquestion(ExamquestionDTO examquestionDTO) {
		// TODO Auto-generated method stub
		Examquestion examquestion = new Examquestion();
        BeanUtils.copyProperties(examquestionDTO, examquestion);
        Examquestion examsave=examquestionrepository.save(examquestion);
        examquestionDTO.setQuestionid(examsave.getQuestionid());
      return examquestionDTO;	

	}

	@Override
	public ExamquestionDTO updateExamquestion(ExamquestionDTO examquestionDTO) {
		// TODO Auto-generated method stub
		Examquestion examquestion = new Examquestion();
	     examquestion.setQuestionid(examquestionDTO.getQuestionid());
	     BeanUtils.copyProperties(examquestionDTO, examquestion);
	     examquestionrepository.save(examquestion);
	     return examquestionDTO;

	}

	@Override
	public boolean deleteExamquestion(ExamquestionDTO examquestionDTO) {
		// TODO Auto-generated method stub
		Examquestion examquestion= new Examquestion();
        BeanUtils.copyProperties(examquestionDTO, examquestion);
        examquestionrepository.delete(examquestion);

		return true;
	}

	@Override
	public ExamquestionDTO getById(int id) {
		// TODO Auto-generated method stub
		Optional<Examquestion> examquestion=examquestionrepository.findById(id);
        if(examquestion.isPresent()) {
        ExamquestionDTO dto=new ExamquestionDTO();
        BeanUtils.copyProperties(examquestion.get(), dto);
         return dto;
      }

		return null;
	}

	@Override
	public List<ExamquestionDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<Examquestion> examquestion=examquestionrepository.findAll();
	     List<ExamquestionDTO> dtos=new ArrayList<>();
		for(Examquestion examQuestion:examquestion ) {
	         ExamquestionDTO dto=new ExamquestionDTO();
	         BeanUtils.copyProperties(examquestion, dto);
	         dtos.add(dto);
	      }

		return null;
	}


}
