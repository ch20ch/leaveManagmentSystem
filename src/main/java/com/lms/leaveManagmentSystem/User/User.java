package com.lms.leaveManagmentSystem.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.lms.leaveManagementSystem.Conf.RoleConstants;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@MappedSuperclass
@EqualsAndHashCode
public abstract class User {
	

   
    @Column
    private String mail;


    @Column
    private String password;

    
    @Column
    private RoleConstants role;

    
    @Column
    private String firstName;

    
    @Column
    private String lastName;

    @Column
    private String function;


    @Column
    private String cin;
    
    @Column
    private int nbrLeaveLeft;
}
