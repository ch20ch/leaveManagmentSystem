package com.lms.leaveManagmentSystem.User;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import com.lms.leaveManagementSystem.Conf.RoleConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@MappedSuperclass
@EqualsAndHashCode
public abstract class User {
	

   
    @Column
    private String mail;


    @Column
    private String password;

    
    @Column
    @Enumerated(EnumType.ORDINAL)
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
