package com.lms.leaveManagmentSystem.Agent;

import javax.transaction.Transactional;

import com.lms.leaveManagmentSystem.User.UserRepository;



@Transactional
public interface AgentRepository extends UserRepository<Agent> {

}
