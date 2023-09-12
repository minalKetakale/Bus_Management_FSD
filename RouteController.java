/*package com.BusManagementPrg.BusController;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import  com.BusManagementPrg.Bus.Route;
import com.BusManagement.BusServiceImplementation.RouteServiceImpl;

import jakarta.validation.Valid;

public class RouteController {

	
	
	@Autowired
	private RouteServiceImpl routeService;
	
	@PostMapping("/admin/route/add")
	public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route){
		
		Route newRoute= routeService.addRoute(route);
		
		return new ResponseEntity<Route>(newRoute,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/route/all")
	public ResponseEntity<List<Route>> getAllRouteHandler(){
		
		List<Route> route= routeService.viewAllRoute();
		
		return new ResponseEntity<>(route,HttpStatus.OK);
	}
	
	
	@GetMapping("/route/{routeID}")
	public ResponseEntity<Route> getAllRouteByRouteIdHandler( @PathVariable Integer routeID){
		
		Route route= routeService.viewRoute(routeID);
		
		return new ResponseEntity<>(route,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/admin/route/update")
	public ResponseEntity<Route> updateRoute(@Valid @RequestBody Route route){
		
		Route newRoute= routeService.updateRoute(route);
		
		return new ResponseEntity<Route>(newRoute,HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/route/delete/{routeID}")
	public ResponseEntity<Route> DeleteRoute(@PathVariable Integer routeID){
		
		Route route = routeService.deleteRoute(routeID);
		
		return new ResponseEntity<Route>(route,HttpStatus.OK);
	}
}*/