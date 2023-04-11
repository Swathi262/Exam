package com.cg.onlineassesment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Status")
public class Examstatus {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int examid;
    private String status;
    private String result;

    @OneToOne
    @JoinColumn(name = "ExamBooking")
    //private Booking booking;

    public int getExamid() {
        return examid;
    }
    public void setExamid(int examid) {
        this.examid = examid;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    

    @Override
    public String toString() {
        return "Examstatus [examid=" + examid + ", status=" + status + ", result=" + result + "]";
    }


}
