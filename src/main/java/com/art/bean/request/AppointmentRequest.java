package com.art.bean.request;

import com.art.bean.entity.Appointment;
/*
　* @Description:
　* @user wangxianchao
　* @date 2018/9/26 17:56
*/
public class AppointmentRequest extends Appointment{
  private String holdDay;

  public String getHoldDay() {
    return holdDay;
  }

  public void setHoldDay(String holdDay) {
    this.holdDay = holdDay;
  }

  @Override
  public String toString() {
    return "AppointmentRequest{" +
        "holdDay='" + holdDay + '\'' +
        '}';
  }
}
