package com.lms.leaveManagmentSystem.Leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.leaveManagmentSystem.Agent.Agent;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
	
	public List<Leave> findByAgent(Agent agent);
}
