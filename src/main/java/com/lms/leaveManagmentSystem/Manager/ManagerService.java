package com.lms.leaveManagmentSystem.Manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ManagerService {
	@Autowired
	private ManagerRepository ManagerRepository;
	Manager newManager;
	
	public Manager createManager(Manager Manager) {
		return ManagerRepository.save(Manager);
	}
	
	public String deleteManagerById(long id) {
		ManagerRepository.deleteById(id);
		return "deleted successful!";
	}
	
	public Iterable<Manager> getAllManager(){
		return ManagerRepository.findAll();
	}
	
	public Manager getManagerById(long id) {
		Optional<Manager> Manager = ManagerRepository.findById(id);
		return Manager.get();
	}

	public Manager updateManager(long id, Manager Manager) {
		newManager = ManagerRepository.findById(id).get();
		newManager.setFirstName(Manager.getFirstName());
		newManager.setLastName(Manager.getLastName());
		newManager.setMail(Manager.getMail());
		newManager.setRole(Manager.getRole());
		newManager.setFunction(Manager.getFunction());
		return ManagerRepository.save(newManager);	
	}
}
