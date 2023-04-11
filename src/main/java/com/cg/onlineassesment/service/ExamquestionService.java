package com.cg.onlineassesment.service;

import java.util.List;

import com.cg.onlineassesment.dao.ExamquestionDTO;

public interface ExamquestionService {
	public ExamquestionDTO addExamquestion(ExamquestionDTO examquestionDTO);

    public ExamquestionDTO updateExamquestion(ExamquestionDTO examquestionDTO);

    public boolean deleteExamquestion(ExamquestionDTO examquestionDTO);

    public ExamquestionDTO getById( int id);

    public List<ExamquestionDTO> findAll();

}
