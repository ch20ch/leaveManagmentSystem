package com.lms.leaveManagmentSystem.Manager;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.lms.leaveManagmentSystem.Leave.Leave;
import com.lms.leaveManagmentSystem.User.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Manager extends User{

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Leave> leaves;
}
