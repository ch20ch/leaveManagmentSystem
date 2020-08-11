package com.lms.leaveManagementSystem.Agent.Leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.leaveManagementSystem.Conf.ResponseEntity;
import com.lms.leaveManagmentSystem.Leave.Leave;
import com.lms.leaveManagmentSystem.Leave.LeaveService;


@RestController
@RequestMapping("/agents")
public class AgentLeaveController {
	@Autowired
	public AgentLeaveService agentLeaveService;
	@Autowired
	public LeaveService leaveService;
	ResponseEntity responseEntity;
	
	@PostMapping("/ll/{id}")
    public ResponseEntity requestLeaveForAgent(@PathVariable long id , @RequestBody Leave leave) {

    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(agentLeaveService.requestLeaveForAgent(id, leave),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }
	@GetMapping("/")
    public ResponseEntity getLeaves() {
    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(leaveService.getAllLeave(),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }
}
