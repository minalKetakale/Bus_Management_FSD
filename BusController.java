package com.BusManagementPrg.BusController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.BusManagementPrg.Bus.Bus;
import com.BusManagementPrg.BusServiceImplimentation.*;


@CrossOrigin(origins = "http://localhost:4200")  
@RestController
@RequestMapping("/api/v1")// Base mapping for all requests to this controller

/* The BusController is a controller class that helps to accept the request 
	and returns the responses*/
public class BusController {


	private BusServiceImplimentation busService;

	public BusController(BusServiceImplimentation busService) {
		this.busService = busService;
	}

	@GetMapping("/matchRoutes")
public ResponseEntity<List<Bus>> getBusDetailsBySrcDest(@RequestParam(required = true) String src, @RequestParam(required = true) String dest) {
		
		try {
			
			List<Bus> busList = busService.getBusDetails(src, dest);

			if (busList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(busList, HttpStatus.OK);  

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Read All the bus Details API
	@GetMapping
	public ResponseEntity<List<Bus>> getBusDetails(@RequestParam(required = false) String name) {
		
		try {
			
			List<Bus> busList = busService.getBusDetailsFromDb(name);
			System.out.println("hello controller");

			if (busList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			System.out.println("hello controler");
			return new ResponseEntity<>(busList, HttpStatus.OK);  

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Insert the bus Details API
	@PostMapping("/savebus")
	public ResponseEntity<Bus> saveBusDetails(@RequestBody Bus bus) {
		try {
			System.out.println("hii controller");
			return new ResponseEntity<Bus>(busService.saveBusDetails(bus), HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Read the bus by ID In API
	@GetMapping("/{id}")
	public ResponseEntity<Bus> getBusDetailsById(@PathVariable("id") int busId) {
		Optional<Bus> busData = busService.getBusDetailsById(busId);

		if(busData.isPresent())
		{
			//return new ResponseEntity<>(busService.getBusDetailsById(busId), HttpStatus.OK);
			return new ResponseEntity<>(busData.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Update bus By Id in the API
	@PutMapping("/{busId}")
	public ResponseEntity<Bus> updateBusDetailsById(@PathVariable int busId, @RequestBody Bus busDetails){
		Optional<Bus> busData=busService.getBusDetailsById(busId);

		if(busData.isPresent())
		{

			busService.updateBusDetailsById(busData, busDetails);
			return new ResponseEntity<>(busService.updateBusDetailsById(busData,busDetails ),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete the bus by ID in the API
	@DeleteMapping("/{id}")	
	public ResponseEntity<String> deleteBusById(@PathVariable("id")  int busId)
	{
		Optional<Bus> busData=busService.getBusDetailsById(busId);

		try {
			if(busData.isPresent())
			{
				busService.deleteBusDetailsById(busId);
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

	 // Delete all buses in the API
	@DeleteMapping 
	public ResponseEntity<HttpStatus> deleteAllBusDetails(){
		try {

			busService.deleteAllBusDetails();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception exception)
		{

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	/*@GetMapping("/availableseat")
	public ResponseEntity<HttpStatus> tocheckavailableSeat() {
		try {
		 busService.availableSeat();

		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/


/*	// Search buses by travellersName from dp api  
	@GetMapping("/readAllBusByDestination/{name}") 
	public ResponseEntity<List<Bus>> getAllBusesByMatchingDestinationName(@PathVariable("name") String name) {
		try {
			if (name != null) {
				return new ResponseEntity<>(busService.Destination(name), HttpStatus.OK);
			}

		} catch (Exception excep) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return null;

	}*/
	
	
	@GetMapping("filter/Price/{direction}")
	public ResponseEntity<List<Bus>> getAllBuseByPriceHightoLow(@PathVariable("direction") String direction,@RequestParam(required = true) String price){
		try {
			System.out.println("i am here!!!");
			List<Bus> busList = busService.getAllBusByPriceDesc(direction,price);
			System.out.println(direction);
			if (busList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(busList, HttpStatus.OK);  

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("filter/Rating/{direction}")
	public ResponseEntity<List<Bus>> getAllBuseByRatingHightoLow(@PathVariable("direction") String direction,@RequestParam(required = true) String ratings){
		try {
			
			List<Bus> busList = busService.getAllBusByRatingsDesc(direction,ratings);

			if (busList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(busList, HttpStatus.OK);  

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Get Bus details if AC is non-available from db api
	@GetMapping("/ACBus")
	public ResponseEntity<List<Bus>> findByAcDomain() {
		try {
			System.out.println("hi");
			List<Bus> buses = busService.findByIsAcBus(true);

			if (buses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(buses, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	 
	// Get Bus details if AC is non-available from db api
	@GetMapping("/nonACBus")
	public ResponseEntity<List<Bus>> findByNonAcDomain() {
		try {
			List<Bus> buses = busService.findByIsAcBus(false);

			if (buses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(buses, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	
	


}	

