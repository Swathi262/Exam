package com.cg.onlineassesment.service;

import java.util.List;

import com.cg.onlineassesment.dao.ExamDTO;

public interface ExamService {
	public ExamDTO addExam(ExamDTO examDTO);

    public ExamDTO updateExam(ExamDTO examDTO);

    public boolean deleteExam(ExamDTO examDTO);

//    public ExamDTO fingById( int id);

    public List<ExamDTO> findAll();
 
    //public ExamDTO findById(int examid);
 
    public ExamDTO getById(int examid);

}
