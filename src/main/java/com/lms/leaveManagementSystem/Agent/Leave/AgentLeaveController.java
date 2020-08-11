package com.lms.leaveManagementSystem.Agent.Leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.leaveManagementSystem.Conf.ResponseEntity;
import com.lms.leaveManagmentSystem.Leave.Leave;


@RestController
@RequestMapping("/agents")
public class AgentLeaveController {
	@Autowired
	private AgentLeaveService agentLeaveService;
	ResponseEntity responseEntity;
	
    @PostMapping("/leaves")
    public ResponseEntity requestCommandForOwner(@RequestHeader long idAgent, @RequestBody Leave leave) {
    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(agentLeaveService.requestLeaveForAgent(idAgent, leave),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }
}
