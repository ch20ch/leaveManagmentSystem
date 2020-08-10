package com.lms.leaveManagmentSystem.Leave;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.lms.leaveManagementSystem.Conf.LeaveTypesConstants;
import com.lms.leaveManagementSystem.Conf.StatusLeaveConstants;

import lombok.Data;


@Data
@Entity(name="leaves")
public class Leave{


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    
    @Column
    private Date startDate;

    
    @Column
    private Date endDate;

 
    @Column
    private LeaveTypesConstants leaveType;


    @Column
    private String reason;

    @Column
    private int duration;



    @Column
    private StatusLeaveConstants status= StatusLeaveConstants.PENDING;
    
    @Column
    private String comment;
    
//    @ManyToOne()
//    private User user;
//  
}
