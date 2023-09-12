package com.BusManagementPrg.BusRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BusManagementPrg.Bus.Bus;
import com.BusManagementPrg.Bus.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer>{
	
	List<Driver> findByNameContainingIgnoreCase(String name);

}
