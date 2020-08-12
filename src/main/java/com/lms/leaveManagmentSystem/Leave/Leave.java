package com.lms.leaveManagmentSystem.Leave;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lms.leaveManagementSystem.Conf.LeaveTypesConstants;
import com.lms.leaveManagementSystem.Conf.StatusLeaveConstants;
import com.lms.leaveManagmentSystem.Agent.Agent;
import com.lms.leaveManagmentSystem.Manager.Manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="leaves")
public class Leave implements Serializable{


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    
    @Column
    private Date startDate;

    
    @Column
    private Date endDate;

 
    @Column
    @Enumerated(EnumType.ORDINAL)
    private LeaveTypesConstants leaveType;


    @Column
    private String reason;

    @Column
    private int duration;



    @Column
    @Enumerated(EnumType.ORDINAL)
    private StatusLeaveConstants status= StatusLeaveConstants.PENDING;
    
    @Column
    private String comment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Agent agent; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager manager; 
}
