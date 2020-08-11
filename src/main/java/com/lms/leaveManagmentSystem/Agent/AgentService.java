package com.lms.leaveManagmentSystem.Agent;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AgentService {

	@Autowired
	private AgentRepository AgentRepository;
	Agent newAgent;
	
	public Agent createAgent(Agent Agent) {
		return AgentRepository.save(Agent);
	}
	
	public String deleteAgentById(long id) {
		AgentRepository.deleteById(id);
		return "deleted successful!";
	}
	
	public Iterable<Agent> getAllAgent(){
		return AgentRepository.findAll();
	}
	
	public Agent getAgentById(long id) {
		Optional<Agent> Agent = AgentRepository.findById(id);
		return Agent.get();
	}

	public Agent updateAgent(long id, Agent Agent) {
		newAgent = AgentRepository.findById(id).get();
		newAgent.setFirstName(Agent.getFirstName());
		newAgent.setLastName(Agent.getLastName());
		newAgent.setMail(Agent.getMail());
		newAgent.setRole(Agent.getRole());
		newAgent.setFunction(Agent.getFunction());
		return AgentRepository.save(newAgent);	
	}
}

