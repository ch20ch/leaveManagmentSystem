package com.lms.leaveManagmentSystem.leaveManager;
//package com.lms.leaveManagementSystem.Manager.Leave;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.digital.factory.command.Command;
//import com.digital.factory.command.CommandService;
//import com.digital.factory.generale.StatusCommandeConstants;
//import com.digital.factory.supplier.comand.SupplierCommandDTO;
//
//@Service
//public class ManagerLeaveService {
//	
//	@Autowired
//	private LeaveService leaveService;
//	Leave command;
//
//	public Leave changeStatusLeave(long idManage, ManagerLeaveDTO managerLeaveDTO) {
//		
//		if(ManagerLeaveDTO.isStatus()) {
//			command = commandService.getCommandById(supplierCommandDTO.getIdCommand());
//			command.setStatus(StatusCommandeConstants.accepted);
//		}else {
//			command = commandService.getCommandById(supplierCommandDTO.getIdCommand());
//			command.setStatus(StatusCommandeConstants.failed);
//		}
//		return commandService.updateCommandStatus(command);
//	}
//
//
//}
