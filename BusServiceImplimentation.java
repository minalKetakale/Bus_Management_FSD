package com.BusManagementPrg.BusServiceImplimentation;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.BusManagementPrg.Bus.Bus;
import com.BusManagementPrg.Bus.User;
import com.BusManagementPrg.BusRepository.BusRepository;
import com.BusManagementPrg.BusService.BusService;

@Service // Indicates that this class is a Spring service component


/* The BUsServiceImplementation class is a service class that provides the business logic 
   It implements the BUsService interface to perform operations(Insert, Read, Update, Delete) on items.
  */
public class BusServiceImplimentation implements BusService {

	@Autowired
	private BusRepository busRepository;
	//private Bus busobj;
	
	//private User userobj;

	public BusServiceImplimentation(BusRepository busRepository) {
		this.busRepository = busRepository;
	}

	@Override

	public Bus saveBusDetails(Bus bus) {
		return busRepository.save(bus);  
	}

	public List<Bus> getBusDetailsFromDb(String name) {
		List<Bus> busdb = new ArrayList<Bus>();
        
		if(name == null)
			busRepository.findAll().forEach(busdb::add); 

		else
			busRepository.findByTravellersNameContainingIgnoreCase(name).forEach(busdb::add);

		return busdb;
	}


	public Optional<Bus> getBusDetailsById(int busId) { 
		Optional<Bus> bus = busRepository.findById(busId);  
		return bus;
	}

	public Bus updateBusDetailsById( Optional<Bus> busDet,Bus newBus) {

		Bus bus=busDet.get();
		bus.setDriverName(newBus.getDriverName());
		bus.setDestination(newBus.getDestination());
		bus.setSource(newBus.getSource());
		bus.setCost(newBus.getCost());
		bus.setTotal_seat(newBus.getTotal_seat());
		bus.setTravellersName(newBus.getTravellersName());
		bus.setRatings(newBus.getRatings());
		//bus.setAvailableSeat(newBus.availableSeat);
		

		return busRepository.save(bus);
	}

	public void deleteBusDetailsById(int busId) {

		busRepository.deleteById(busId);

	}

	public void deleteAllBusDetails() {
		busRepository.deleteAll();

	}


	//select * from t where travellersName like ??

/*	public List<Bus> Destination(String name) {
		List<Bus> busList = new ArrayList<Bus>();
		busRepository.findByDestinationContainingIgnoreCase(name).forEach(busList::add);
		return busList;


	}*/
	
	
	public List<Bus> findByTravelerNameContainingIgnoreCase(String travellersName) {
		List<Bus> busList = new ArrayList<Bus>();
		busRepository.findByTravellersNameContainingIgnoreCase(travellersName).forEach(busList::add);
		 return busList;
		
		
	}


	public List<Bus>findByIsAcBus(boolean isACBus)
	{
		List<Bus> busList = new ArrayList<Bus>();
		busRepository.findByIsAcBus(isACBus).forEach(busList :: add);
		return busList;


	}

	public List<Bus> getBusDetails(String src, String dest) {
		
		List<Bus> bus = new ArrayList<Bus>();

		
			busRepository.findBySourceAndDestination(src,dest).forEach(bus::add);

		return bus;
	}

	public List<Bus> getAllBusByPriceDesc(String direction,String price) {
		
		List<Bus> bus = busRepository.findAll(Sort.by(getSortDirection(direction),price));
		return bus;
	}

	
	public List<Bus> getAllBusByRatingsDesc(String direction,String ratings) {

		List<Bus> bus = busRepository.findAll(Sort.by(getSortDirection(direction),ratings));
		return bus;
	}
	
	private Sort.Direction getSortDirection(String direction){
		if(direction.equals("asc")){
			System.out.println("came here");
			return Sort.Direction.ASC;
		}
		else if(direction.equals("desc")) {
			System.out.println("came here desc");
			return Sort.Direction.DESC;
		}
		return Sort.Direction.ASC;
				
	}
	
/*	public void availableSeat() {
	busobj.setAvailableSeat(busobj.getTotal_seat());
	//bus.availableSeat=bus.getTotal_seat()-userobj.getNumOfTicket();
		System.out.println(busobj.availableSeat);
	
		
	}*/

	
}









