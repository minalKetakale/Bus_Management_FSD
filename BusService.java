package com.BusManagementPrg.BusService;

import java.util.List;
import java.util.Optional;

import com.BusManagementPrg.Bus.Bus;
/* The BusService is service interface 
 * and abstract method declaration
  */
public interface BusService {

    // Method to save a new Bus entity to the database
    Bus saveBusDetails(Bus bus);

    // Method to retrieve all Bus entities from the database
    List<Bus> getBusDetailsFromDb(String str);

    // Method to retrieve a specific Bus entity by its ID
    Optional<Bus> getBusDetailsById(int busId);

    // Method to update an existing Bus entity in the database based on its ID
    Bus updateBusDetailsById( Optional<Bus> busDet,Bus newVal);

    // Method to delete a specific Bus entity from the database based on its ID
    void deleteBusDetailsById(int busId);

    // Method to delete all Bus entities from the database
    void deleteAllBusDetails();
}
