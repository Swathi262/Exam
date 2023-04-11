package com.cg.onlineassesment.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineassesment.dao.ExamstatusDTO;
import com.cg.onlineassesment.entity.Examstatus;
import com.cg.onlineassesment.repository.ExamstatusRepository;
import com.cg.onlineassesment.service.ExamstatusService;

@Service
public class ExamstatusServiceImpl implements ExamstatusService{
	@Autowired
	private ExamstatusRepository examstatusrepository;

	@Override
	public ExamstatusDTO addExamstatus(ExamstatusDTO examstatusDTO) {
		// TODO Auto-generated method stub
		Examstatus examstatus = new Examstatus();
        BeanUtils.copyProperties(examstatusDTO, examstatus);
        Examstatus examsave=examstatusrepository.save(examstatus);
        examstatusDTO.setExamid(examsave.getExamid());
      return examstatusDTO;

	}

	@Override
	public ExamstatusDTO updateExamstatus(ExamstatusDTO examstatusDTO) {
		// TODO Auto-generated method stub
		Examstatus examstatus = new Examstatus();
	     examstatus.setExamid(examstatusDTO.getExamid());
	     BeanUtils.copyProperties(examstatusDTO, examstatus);
	     examstatusrepository.save(examstatus);
	     return examstatusDTO;

	}

	@Override
	public boolean deleteExamstatus(ExamstatusDTO examstatusDTO) {
		// TODO Auto-generated method stub
		Examstatus examstatus = new Examstatus();
        BeanUtils.copyProperties(examstatusDTO, examstatus);
        examstatusrepository.delete(examstatus);
        return true;

	}

	@Override
	public ExamstatusDTO getById(int id) {
		// TODO Auto-generated method stub
	     Optional<Examstatus> examstatus=examstatusrepository.findById(id);
         if(examstatus.isPresent()) {
         ExamstatusDTO dto=new ExamstatusDTO();
         BeanUtils.copyProperties(examstatus.get(), dto);
          return dto;
       }


		return null;
	}

	@Override
	public List<ExamstatusDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<Examstatus> examstatus=examstatusrepository.findAll();
	     List<ExamstatusDTO> dtos=new ArrayList<>();
	     for(Examstatus examsStatus:examstatus ) {
	         ExamstatusDTO dto=new ExamstatusDTO();
	         BeanUtils.copyProperties(examsStatus, dto);
	         dtos.add(dto);
	      }

		return null;
	}

}
