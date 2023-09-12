package com.BusManagementPrg.BusService;

import java.util.List;
import java.util.Optional;

import com.BusManagementPrg.Bus.Bus;
import com.BusManagementPrg.Bus.User;


public interface UserService {
	public void addUser(User obj);
	public List<User> findBookedUsersByBusId(long busId);
	
	Optional<User> getUserDetailsById(int userID);
	
	void deleteUserDetailsById(int userID);
}