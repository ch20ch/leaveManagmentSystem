package com.lms.leaveManagmentSystem.leaveManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.leaveManagementSystem.Conf.StatusLeaveConstants;
import com.lms.leaveManagmentSystem.Agent.Agent;
import com.lms.leaveManagmentSystem.Agent.AgentService;
import com.lms.leaveManagmentSystem.Leave.Leave;
import com.lms.leaveManagmentSystem.Leave.LeaveService;
import com.lms.leaveManagmentSystem.Manager.Manager;
import com.lms.leaveManagmentSystem.Manager.ManagerService;


@Service
public class ManagerLeaveService {
	
	@Autowired
	private LeaveService leaveService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private ManagerService managerService;
	Leave leave;

	public Leave changeStatusLeave(long idManage, Leave leave, StatusLeaveConstants status  ) {
		
		leave.setStatus(status);
		leaveService.updateLeaveStatus(leave);
		return leave;
		
	}
    public Leave updateLeave(long idManage, Leave leave ) {
		
    	leaveService.updateLeaveStatus(leave);
		return leave;
		
	}
    public Leave addLeaveForAgent(long idManage,long idAgent, Leave leave ) {
		Agent agent = agentService.getAgentById(idAgent);
		Manager manager = managerService.getManagerById(idManage);
		leave.setAgent(agent);
		leave.setManager(manager);
		agent.getLeaves().add(leave);
		manager.getLeaves().add(leave);
		Leave lleave = leaveService.saveLeave(leave);
		return leave; 

		
	}



}
