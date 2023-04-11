package com.cg.onlineassesment.service;

import java.util.List;

import com.cg.onlineassesment.dao.ExamstatusDTO;

public interface ExamstatusService {
	
	public ExamstatusDTO addExamstatus(ExamstatusDTO examstatusDTO);

    public ExamstatusDTO updateExamstatus(ExamstatusDTO examstatusDTO);

    public boolean deleteExamstatus(ExamstatusDTO examstatusDTO);

    public ExamstatusDTO getById( int id);

    public List<ExamstatusDTO> findAll();

}
