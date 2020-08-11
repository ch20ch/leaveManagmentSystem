package com.lms.leaveManagmentSystem.Leave;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.leaveManagmentSystem.Agent.Agent;
import com.lms.leaveManagmentSystem.Agent.AgentRepository;
import com.lms.leaveManagmentSystem.Manager.Manager;
import com.lms.leaveManagmentSystem.Manager.ManagerRepository;



@Service
public class LeaveService {
	@Autowired
    private LeaveRepository LeaveRepository;


	
	public Leave saveLeave(Leave Leave) {
		
		return LeaveRepository.save(Leave);
	}
	
	public Leave updateLeaveStatus(Leave Leave) {
		return LeaveRepository.save(Leave);
	}
	
	public String deleteLeaveById(long id) {
		LeaveRepository.deleteById(id);
		return "deleted successful!";
	}
	
	public Iterable<Leave> getAllLeave(){
		return LeaveRepository.findAll();
	}
	
	public Leave getLeaveById(long id) {
		Optional<Leave> Leave = LeaveRepository.findById(id);
		return Leave.get();
	}
	
	
}
