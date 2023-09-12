package com.BusManagementPrg.BusServiceImplimentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BusManagementPrg.Bus.Bus;
import com.BusManagementPrg.Bus.Driver;
import com.BusManagementPrg.BusRepository.BusRepository;
import com.BusManagementPrg.BusRepository.DriverRepository;
import com.BusManagementPrg.BusService.DriverService;


@Service
public class DriverServiceImplementation implements DriverService{


	@Autowired
	private DriverRepository driverRepository;
	//private Bus busobj;

	//private User userobj;
    @Autowired
	public DriverServiceImplementation(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	@Override

	public Driver saveDriverDetails(Driver driver) {
		return driverRepository.save(driver);  
	}

	@Override
	public List<Driver> getDriverDetailsFromDb(String name) {
		List<Driver> driverdb = new ArrayList<Driver>();

		if(name == null)
			driverRepository.findAll().forEach(driverdb::add); 

		else
			driverRepository.findByNameContainingIgnoreCase(name).forEach(driverdb::add);

		return driverdb;
	}

	public Optional<Driver> getDriverDetailsById(int driverId) {
		
		Optional<Driver> driver = driverRepository.findById(driverId);  
		return driver;
		
	}

	@Override
	public Driver updateDriverDetailsById(Optional<Driver> driverDet, Driver newVal) {
	

		Driver driver=driverDet.get();
		driver.setName(newVal.getName());
		driver.setAge(newVal.getAge());
		driver.setDriverEmail(newVal.getDriverEmail());
		driver.setIdProofNo(newVal.getIdProofNo());
		driver.setMobileNo(newVal.getMobileNo());
		
			

			return driverRepository.save(driver);
		
	}

	@Override
	public void deleteDriverDetailsById(int driverId) {
		driverRepository.deleteById(driverId);

	}


}
