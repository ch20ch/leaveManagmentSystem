package com.lms.leaveManagmentSystem.managerAgent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.leaveManagementSystem.Conf.ResponseEntity;
import com.lms.leaveManagmentSystem.Agent.AgentService;

@RestController
@RequestMapping("/manager/agents")
public class ManagerAgentController {
	

	@Autowired
	private ManagerAgentService managerAgentService;
	ResponseEntity responseEntity;
	
	@GetMapping("/")
    public ResponseEntity getAgents() {
    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(managerAgentService.getAllAgent(),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }

}
