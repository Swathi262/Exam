package com.cg.onlineassesment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Examination")
public class Exam {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int examid;
//    @NotEmpty(message="ExamName is required")
//    @Size(min=3, max=15, message="exam name should be between 3-15 charcaters")
    private String examname;
    private String examsubject;
//    @NotEmpty(message="ExamDuration is required")
//    @Size(min=2, max=6, message="exam should be between 2-6 hours")
    private String examduration;
    private int noofquestions;
    private String examdate;
    private double price;

    @ManyToOne
    @JoinColumn(name = "candidate")
    private Candidate candidate;



    public Exam() {
        super();
        // TODO Auto-generated constructor stub
    }




    public Exam(String examname, String examsubject, String examduration, int noofquestions, String examdate,
            double price, Candidate candidate) {
        super();
        this.examname = examname;
        this.examsubject = examsubject;
        this.examduration = examduration;
        this.noofquestions = noofquestions;
        this.examdate = examdate;
        this.price = price;
        this.candidate = candidate;
    }
 
 

    public int getExamid() {
        return examid;
    }
    public void setExamid(int examid) {
        this.examid = examid;
    }
    public String getExamname() {
        return examname;
    }
    public void setExamname(String examname) {
        this.examname = examname;
    }
    public String getExamsubject() {
        return examsubject;
    }
    public void setExamsubject(String examsubject) {
        this.examsubject = examsubject;
    }
    public String getExamduration() {
        return examduration;
    }
    public void setExamduration(String examduration) {
        this.examduration = examduration;
    }
    public int getNoofquestions() {
        return noofquestions;
    }
    public void setNoofquestions(int noofquestions) {
        this.noofquestions = noofquestions;
    }
    public String getExamdate() {
        return examdate;
    }
    public void setExamdate(String examdate) {
        this.examdate = examdate;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Exam [examid=" + examid + ", examname=" + examname + ", examsubject=" + examsubject + ", examduration="
                + examduration + ", noofquestions=" + noofquestions + ", examdate=" + examdate + ", price=" + price
                + "]";
    }


}
