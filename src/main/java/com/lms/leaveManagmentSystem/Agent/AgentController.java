package com.lms.leaveManagmentSystem.Agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.leaveManagementSystem.Conf.ResponseEntity;
import com.lms.leaveManagmentSystem.Leave.Leave;
import com.lms.leaveManagmentSystem.Leave.LeaveService;
import com.lms.leaveManagmentSystem.leaveAgent.AgentLeaveService;



@RestController
@RequestMapping("/agents")
public class AgentController {


	@Autowired
	private AgentService AgentService;
	@Autowired
	private LeaveService leaveService;
	ResponseEntity responseEntity;
	
    @GetMapping("/")
    public ResponseEntity getAgents() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(AgentService.getAllAgent(),200);
    }
    @GetMapping(path = "/", params = { "page", "size" })
    public ResponseEntity getAgents(@RequestParam("page") int page, 
    								@RequestParam("size") int size) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(AgentService.getAllAgent(page,size),200);
    }
    @GetMapping(path = "/", params = { "page", "size","sortDir","sort" })
    public ResponseEntity getAgents(@RequestParam("page") int page, 
    								@RequestParam("size") int size,
    								@RequestParam("size") String sortDir,
    								@RequestParam("size") String sort) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(AgentService.getAllAgent(page,size,sortDir,sort),200);
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
    @PostMapping("/leaves")
	  public ResponseEntity requestLeaveForAgent(@RequestParam long idAgent,@RequestBody Leave leave) {
	  	responseEntity = new ResponseEntity();
	  	try {
	  		Leave lleave = leaveService.saveLeave(leave);
			Agent agent = AgentService.getAgentById(idAgent);
			agent.getLeaves().add(lleave);
	      	return responseEntity.setMessage(agent,200);
	  	}catch(Exception e) {
	      	return responseEntity.setErrorMessage(e.toString(), 403);
	  	}
	  }

}

