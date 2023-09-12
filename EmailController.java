package com.BusManagementPrg.BusController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BusManagementPrg.Bus.Bus;
import com.BusManagementPrg.BusService.EmailService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	@RequestMapping("/")
	public ResponseEntity<String> checkEmail(@RequestParam(required = false) String userEmail, @RequestBody Bus busDetails )  //user email, rest obj(@request Body 
	{
		String busName=busDetails.getTravellersName();
		String strMsg = busDetails.getDestination()+" "+busDetails.getTravellersName()+" "+busDetails.getIsAcBus();
		
	System.out.println(busDetails);	
	emailService.sendEmail(userEmail, "Your table booking is confirmed!", "We are happy to inform you that your booking for a seat in "
			+ " travellers Name:"+ busName +" is confirmed! You can find your seat booking information below.\n"
			+strMsg+" ");
	return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
	}
}

