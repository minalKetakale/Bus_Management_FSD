package com.BusManagementPrg.BusController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BusManagementPrg.Bus.Bus;
import com.BusManagementPrg.Bus.User;
import com.BusManagementPrg.BusRepository.BusRepository;
import com.BusManagementPrg.BusServiceImplimentation.BusServiceImplimentation;
import com.BusManagementPrg.BusServiceImplimentation.UserServiceImplementation;

import com.BusManagementPrg.BusController.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

	//open postm
	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	public UserController(UserServiceImplementation userService) {
		this.userServiceImplementation = userService;
	}

	
	@Autowired
	private BusRepository busRepo;
	
	
		@PostMapping("/bookBus/{busId}")
		public ResponseEntity<Map<String,String>> addBooking(@PathVariable("busId") int busId,@RequestBody User user)
		{
			Optional<Bus> busobj=busRepo.findById(busId);
			
			user.setBusDetails(this.busRepo.findById( busId).get());
			this.userServiceImplementation.addUser(user);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "Your Booking is Confirmed!!");
		
				return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
		
	}
	
	

	@GetMapping("/bookedUsers/{busId}")
	public List<User> getUsersByBusId(@PathVariable long busId)
	{
		List<User> userList = new ArrayList<User>();
		userList = this.userServiceImplementation.findBookedUsersByBusId(busId);

		return  userList;

	}
	
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getUserDetailsById(@PathVariable("id") int userID) {
		Optional<User> userData = userServiceImplementation.getUserDetailsById(userID);

		if(userData.isPresent())
		{
			//return new ResponseEntity<>(busService.getBusDetailsById(busId), HttpStatus.OK);
			return new ResponseEntity<>(userData.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")	
	public ResponseEntity<String> deleteUserDetailsById(@PathVariable("id")  int userID)
	{
		Optional<User> userData=userServiceImplementation.getUserDetailsById(userID);

		try {
			if(userData.isPresent())
			{
				userServiceImplementation.deleteUserDetailsById(userID);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
   }


}