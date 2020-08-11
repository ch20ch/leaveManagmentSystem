package com.lms.leaveManagmentSystem.Agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.leaveManagementSystem.Conf.ResponseEntity;



@RestController
@RequestMapping("/agents")
public class AgentController {


	@Autowired
	private AgentService AgentService;
	ResponseEntity responseEntity;
	
    @GetMapping("/")
    public ResponseEntity getAgents() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(AgentService.getAllAgent(),200);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getAgentById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(AgentService.getAgentById(id),200);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAgentById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(AgentService.deleteAgentById(id),200);
    }
    
    
    @PostMapping("/")
    public ResponseEntity createAgent(@RequestBody Agent Agent) {
    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(AgentService.createAgent(Agent),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }

}

