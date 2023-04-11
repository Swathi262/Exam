package com.cg.onlineassesment.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineassesment.dao.ExamDTO;
import com.cg.onlineassesment.entity.Exam;
import com.cg.onlineassesment.repository.ExamRepository;
import com.cg.onlineassesment.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService{

	
	@Autowired
	private ExamRepository repository;
	@Override
	public ExamDTO addExam(ExamDTO examDTO) {
		// TODO Auto-generated method stub
		Exam exam = new Exam();
        BeanUtils.copyProperties(examDTO, exam);
        Exam examsave=repository.save(exam);
        examDTO.setExamid(examsave.getExamid());
        return examDTO;

	}

	@Override
	public ExamDTO updateExam(ExamDTO examDTO) {
		// TODO Auto-generated method stub
		Exam exam = new Exam();
        exam.setExamid(examDTO.getExamid());
        BeanUtils.copyProperties(examDTO, exam);
        repository.save(exam);
        return examDTO;

	}

	@Override
	public boolean deleteExam(ExamDTO examDTO) {
		// TODO Auto-generated method stub
		
		Exam exam = new Exam();
        BeanUtils.copyProperties(examDTO, exam);
        repository.delete(exam);

		return true;
	}

	@Override
	public List<ExamDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<Exam> exam=repository.findAll();
        List<ExamDTO> dtos=new ArrayList<>();
        for(Exam exams:exam ) {
            ExamDTO dto=new ExamDTO();
            BeanUtils.copyProperties(exams, dto);
            dtos.add(dto);
        }

		return null;
	}

	@Override
	public ExamDTO getById(int examid) {
		// TODO Auto-generated method stub
		Optional<Exam> exam =repository.findById(examid);
        if (exam.isPresent()) {
            ExamDTO dto = new ExamDTO();
            BeanUtils.copyProperties(exam.get(), dto);
            return dto;
        }

		return null;
	}

}
