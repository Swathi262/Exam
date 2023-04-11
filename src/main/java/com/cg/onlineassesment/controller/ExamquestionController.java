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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineassesment.dao.ExamquestionDTO;
import com.cg.onlineassesment.service.ExamquestionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/Examquestion")
public class ExamquestionController {
	@Autowired
	public ExamquestionService examquestionService;

    //http://localhost:9090/api/Examstatus/addExamstatus
    @PostMapping("/addExamquestion")
    public ResponseEntity<ExamquestionDTO> addExamstatus(@RequestBody ExamquestionDTO examquestiones){
        ExamquestionDTO saveexamquestion = examquestionService.addExamquestion(examquestiones);
        return ResponseEntity.ok(saveexamquestion);
    }

    @GetMapping("/fetchExamquestionById/{id}")
    public ResponseEntity<ExamquestionDTO> getExamstatus(@PathVariable int id){
        ExamquestionDTO examquestion = examquestionService.getById(id);
        return new ResponseEntity<ExamquestionDTO>(examquestion,HttpStatus.FOUND);
        }


    @PutMapping("/updateExamquestion")
    public ResponseEntity<ExamquestionDTO>updateExamstatus(@RequestBody ExamquestionDTO examquestionDTO){
        return new ResponseEntity<ExamquestionDTO>(examquestionService.updateExamquestion(examquestionDTO),HttpStatus.ACCEPTED); 
    }

    @DeleteMapping("/deleteExamquestion/{id}")
    public ResponseEntity<Boolean> deleteExamquestionById(@PathVariable int id){
        ExamquestionDTO examquestionDTO = examquestionService.getById(id);
        if(examquestionDTO !=null) {
        examquestionService.deleteExamquestion(examquestionDTO);
        return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
    }
    //throw new ExamstatusNotFoundException("Examstatus not Found");
		return null;
}

    @GetMapping("/fetchAllExamquestion")
    public ResponseEntity<List<ExamquestionDTO>> getAllExamquestion(){
        List<ExamquestionDTO> list=examquestionService.findAll();
        return ResponseEntity.ok(list);
    }

}
