package com.art.bean.entity;

import java.util.Date;

public class Appointment {

    private Integer id;
    private Integer bookId;
    private Integer userNumber;
    private Date appointmentTime;
    private Date expectReturnTime;
    private Date realReturnTime;
    private Integer status;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public Integer getUserNumber() {
        return userNumber;
    }
    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }
    public Date getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public Date getExpectReturnTime() {
        return expectReturnTime;
    }
    public void setExpectReturnTime(Date expectReturnTime) {
        this.expectReturnTime = expectReturnTime;
    }
    public Date getRealReturnTime() {
        return realReturnTime;
    }
    public void setRealReturnTime(Date realReturnTime) {
        this.realReturnTime = realReturnTime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "id=" + id +
            ", bookId=" + bookId +
            ", userNumber=" + userNumber +
            ", appointmentTime=" + appointmentTime +
            ", expectReturnTime=" + expectReturnTime +
            ", realReturnTime=" + realReturnTime +
            ", status=" + status +
            '}';
    }
}