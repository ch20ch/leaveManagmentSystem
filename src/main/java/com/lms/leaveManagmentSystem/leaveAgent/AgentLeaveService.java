package com.lms.leaveManagmentSystem.leaveAgent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.leaveManagmentSystem.Agent.Agent;
import com.lms.leaveManagmentSystem.Agent.AgentService;
import com.lms.leaveManagmentSystem.Leave.Leave;
import com.lms.leaveManagmentSystem.Leave.LeaveService;


@Service
public class AgentLeaveService {
	@Autowired
	private AgentService agentService;
	@Autowired 
	private LeaveService leaveService;
	
	public  Agent requestLeaveForAgent(long idAgent, Leave leave) {
		Leave lleave = leaveService.saveLeave(leave);
		Agent agent = agentService.getAgentById(idAgent);
		agent.getLeaves().add(lleave);
		// agentService.createAgent(agent);
		return agent;
	}
}
