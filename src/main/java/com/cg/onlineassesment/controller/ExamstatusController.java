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

import com.cg.onlineassesment.dao.ExamstatusDTO;
import com.cg.onlineassesment.exception.ExamstatusNotFoundException;
import com.cg.onlineassesment.service.ExamstatusService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/Examstatus")
public class ExamstatusController {

@Autowired
public ExamstatusService examstatusService;

//http://localhost:9090/api/Examstatus/addExamstatus
@PostMapping("/addExamstatus")
public ResponseEntity<ExamstatusDTO> addExamstatus(@RequestBody ExamstatusDTO examstatuses){
    ExamstatusDTO saveexamstatus = examstatusService.addExamstatus(examstatuses);
    return ResponseEntity.ok(saveexamstatus);
}

@GetMapping("/fetchExamstatusById/{id}")
public ResponseEntity<ExamstatusDTO> getExamstatus(@PathVariable int id){
    ExamstatusDTO examstatus = examstatusService.getById(id);
    return new ResponseEntity<ExamstatusDTO>(examstatus,HttpStatus.FOUND);
    }


@PutMapping("/updateExamstatus")
public ResponseEntity<ExamstatusDTO>updateExamstatus(@RequestBody ExamstatusDTO examstatusDTO){
    return new ResponseEntity<ExamstatusDTO>(examstatusService.updateExamstatus(examstatusDTO),HttpStatus.ACCEPTED); 
}

@DeleteMapping("/deleteExamstatus/{id}")
public ResponseEntity<Boolean> deleteExamstatusById(@PathVariable int id){
    ExamstatusDTO examstatusDTO = examstatusService.getById(id);
    if(examstatusDTO !=null) {
    examstatusService.deleteExamstatus(examstatusDTO);
    return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
}
throw new ExamstatusNotFoundException("Examstatus not Found");
}

@GetMapping("/fetchAllExamstatus")
public ResponseEntity<List<ExamstatusDTO>> getAllExamstatus(){
    List<ExamstatusDTO> list=examstatusService.findAll();
    return ResponseEntity.ok(list);
}

}
