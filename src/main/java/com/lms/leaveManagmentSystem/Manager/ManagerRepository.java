package com.lms.leaveManagmentSystem.Manager;

import javax.transaction.Transactional;

import com.lms.leaveManagmentSystem.User.UserRepository;



@Transactional
public interface ManagerRepository extends UserRepository<Manager> {

}