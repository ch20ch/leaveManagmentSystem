package com.lms.leaveManagmentSystem.Agent;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lms.leaveManagmentSystem.User.UserRepository;



@Transactional
public interface AgentRepository extends UserRepository<Agent> {
	
	Page<Agent> findAll(Pageable pageable);

}
