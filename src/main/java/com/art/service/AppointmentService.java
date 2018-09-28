package com.art.service;

import com.art.bean.request.AppointmentRequest;
import com.art.bean.entity.Appointment;

/*
　* @Description:
　* @user wangxianchao
　* @date 2018/9/26 17:57
*/
public interface AppointmentService {
  int appoint(AppointmentRequest record);
  int returnBook(Appointment record);
}
