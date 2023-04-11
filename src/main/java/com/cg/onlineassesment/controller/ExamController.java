package com.cg.onlineassesment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineassesment.dao.ExamDTO;
import com.cg.onlineassesment.exception.ExamNotFoundException;
import com.cg.onlineassesment.service.ExamService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ExamController {
	@Autowired
	public ExamService examService;

    //http://localhost:9091/api/exam
    @PostMapping("/exam")
    public ResponseEntity<ExamDTO> addExam(@RequestBody ExamDTO examDTO) {
    ExamDTO exam = examService.addExam(examDTO);
    return ResponseEntity.ok(exam);

//    public Exam createExam(@RequestBody Exam exam) {
//                return ExamRepository.save(exam);
//            
    } 


    //http://localhost:9091/api/fetchExamById/{examid}
    @GetMapping("/fetchExamById/{examid}")
    public ResponseEntity<ExamDTO> getById(@PathVariable int examid) {
        ExamDTO examDTO = examService.getById(examid);
        return new ResponseEntity<ExamDTO>(examDTO, HttpStatus.FOUND);
    }

//    public ResponseEntity<ExamDTO> getExamById(@PathVariable int examid){
//        ExamDTO examDTO = examService.findById(examid);
////                .orElseThrow(() -> new ExamNotFoundException("Exam not exists with id :"+ id));
//            return ResponseEntity.ok(examDTO);
//                
//    }

    //http://localhost:9091/api/updateExam
    @PutMapping("/updateExam")
    public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO examDTO) {
        return new ResponseEntity<ExamDTO>(examService.updateExam(examDTO), HttpStatus.ACCEPTED);

    }
    //http://localhost:9091/api/deleteExam/id
    @DeleteMapping("/deleteExam/{examid}")
    public ResponseEntity<Boolean> deleteExamById(@PathVariable int examid) {
        ExamDTO examDTO = examService.getById(examid);
        if (examDTO != null) {
        examService.deleteExam(examDTO);
            return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
        }
        throw new ExamNotFoundException("Exam doesn't Registered");
    }


    //http://localhost:9091/api/exam
    @GetMapping("/exam")
    public ResponseEntity<List<ExamDTO>> getAllExam() {
        List<ExamDTO> list = examService.findAll();
        return ResponseEntity.ok(list);
    }


}
