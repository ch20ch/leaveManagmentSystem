package com.lms.leaveManagmentSystem.leaveAgent;

import java.util.List;

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
	
	public  Leave requestLeaveForAgent(long idAgent, Leave leave) {
		Agent agent = agentService.getAgentById(idAgent);
		System.out.print("get agent ID "+agent.getId());
		leave.setAgent(agent);
		agent.getLeaves().add(leave);
		Leave lleave = leaveService.saveLeave(leave);

	
		return lleave;
	}
	public  List<Leave> getLeavesByAgent(long idAgent) {
		Agent agent = agentService.getAgentById(idAgent);
		List<Leave> leaves = leaveService.getLeaveByAgent(agent);
		return leaves; 
	}
	public  List<Leave> getLeaves() {
		List<Leave> leaves = leaveService.getAllLeave();
		return leaves; 
	}
}
