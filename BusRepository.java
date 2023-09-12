package com.BusManagementPrg.BusRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BusManagementPrg.Bus.Bus;

@Repository // Indicates that this interface is a Spring bean and serves as a repository

/* BusRepository interface extends the  JpaRepository
 * JpaRepository is a generic interface that provides basic CRUD operations
 */
public interface BusRepository extends JpaRepository<Bus, Integer> {
   

   
   
    List<Bus> findByIsAcBus(boolean status);
	List< Bus> findByTravellersNameContainingIgnoreCase(String name);
	List<Bus>findBySourceAndDestination(String src,String dest);
	//List<Bus> findByDestinationContainingIgnoreCase(String name);
		

}




