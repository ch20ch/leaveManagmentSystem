package com.lms.leaveManagmentSystem.managerAgent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.leaveManagmentSystem.Agent.Agent;
import com.lms.leaveManagmentSystem.Agent.AgentService;
import com.lms.leaveManagmentSystem.Leave.Leave;
import com.lms.leaveManagmentSystem.Manager.Manager;
import com.lms.leaveManagmentSystem.Manager.ManagerService;

@Service
public class ManagerAgentService {
	@Autowired
	private ManagerService ManagerService;
	@Autowired
	private AgentService AgentService;

	
	public  Agent addAgent(long idManager, Agent agent) {
		Manager manager = ManagerService.getManagerById(idManager);
		Agent Agent = AgentService.createAgent(agent);
		
		return Agent;
	}
	public  Agent deleteAgent(long idManager, Agent agent) {
		Manager manager = ManagerService.getManagerById(idManager);
		Agent Agent = AgentService.createAgent(agent);
		
		return Agent;
	}
}
