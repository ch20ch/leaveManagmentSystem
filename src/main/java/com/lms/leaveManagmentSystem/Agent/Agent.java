package com.lms.leaveManagmentSystem.Agent;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.lms.leaveManagmentSystem.Leave.Leave;
import com.lms.leaveManagmentSystem.User.User;

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
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Agent extends User implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	// @OneToMany(cascade = CascadeType.ALL,mappedBy = "agent",fetch = FetchType.LAZY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Leave> leaves;
}
