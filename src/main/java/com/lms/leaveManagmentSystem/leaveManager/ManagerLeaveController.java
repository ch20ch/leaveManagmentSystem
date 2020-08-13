package com.lms.leaveManagmentSystem.leaveManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.leaveManagementSystem.Conf.ResponseEntity;
import com.lms.leaveManagmentSystem.Leave.Leave;

@RestController
@RequestMapping("/leaves/managers")
public class ManagerLeaveController {
	
	@Autowired
	private ManagerLeaveService managerLeaveService; 
	ResponseEntity responseEntity; 
	
	
	@PostMapping("/")
    public ResponseEntity requestLeaveForAgent(@RequestParam long idManager ,@RequestParam long idAgent, @RequestBody Leave leave) {

    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(managerLeaveService.addLeaveForAgent(idManager, idAgent, leave),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }
	@PostMapping("/{id}")
    public ResponseEntity updateStatusLeave(@PathVariable long id , @RequestBody Leave leave) {

    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(managerLeaveService.updateLeave(id, leave),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }
}
