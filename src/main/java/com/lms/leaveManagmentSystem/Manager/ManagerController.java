package com.lms.leaveManagmentSystem.Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.leaveManagementSystem.Conf.ResponseEntity;
import com.lms.leaveManagmentSystem.Agent.Agent;
import com.lms.leaveManagmentSystem.Agent.AgentService;
import com.lms.leaveManagmentSystem.Manager.Manager;
import com.lms.leaveManagmentSystem.Manager.ManagerService;

@RestController
@RequestMapping("/Managers")
public class ManagerController {
	@Autowired
	private ManagerService ManagerService;
	@Autowired
	private AgentService agentService;
	ResponseEntity responseEntity;
	
    @GetMapping("/")
    public ResponseEntity getManagers() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(ManagerService.getAllManager(),200);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getManagerById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(ManagerService.getManagerById(id),200);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteManagerById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(ManagerService.deleteManagerById(id),200);
    }
    
    
    @PostMapping("/")
    public ResponseEntity createManager(@RequestBody Manager Manager) {
    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(ManagerService.createManager(Manager),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }

//    @GetMapping("/Agents")
//    public ResponseEntity getAllUsers() {
//    	responseEntity = new ResponseEntity();
//    	try {
//        	return responseEntity.setMessage(agentService.getAllAgent(),200);
//    	}catch(Exception e) {
//        	return responseEntity.setErrorMessage(e.toString(), 403);
//    	}
//    }




}
