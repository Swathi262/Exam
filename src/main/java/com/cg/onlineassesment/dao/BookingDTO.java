package com.cg.onlineassesment.dao;

public class BookingDTO {
	private int bookingid;
    private int examid;
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

}
