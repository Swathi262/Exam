package com.cg.onlineassesment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Booking")
public class Booking {
	@Id
    private int bookingid;
//	@ManyToOne(CascadeType.ALL)
    private int examid;
	//@OneToMany(CascadeType.ALL)
    private int candidateid;
    private String bookingdate;


    public int getBookingid() {
        return bookingid;
    }
    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public int getExamid() {
        return examid;
    }
    public void setExamid(int examid) {
        this.examid = examid;
    }
    public int getCandidateid() {
        return candidateid;
    }
    public void setCandidateid(int candidateid) {
        this.candidateid = candidateid;
    }
    public String getBookingdate() {
        return bookingdate;
    }
    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

   
    
    @Override
    public String toString() {
        return "ExamBooking [bookingid=" + bookingid + ", examid=" + examid + ", candidateid=" + candidateid
                + ", bookingdate=" + bookingdate + "]";
    }


}
