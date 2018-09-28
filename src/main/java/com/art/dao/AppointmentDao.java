package com.art.dao;

import com.art.bean.entity.Appointment;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {
    int updateByPrimaryKey(Appointment record);
}