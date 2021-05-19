package net.finman.service;

import java.util.List;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.UserCustomer;

public interface CustomerService {
    /**
     * Creates a customer and stores it in the database.
     * 
     * @param customer The customer model to be added.
     * @throws ResourceNotCreatedException
     */
    void createCustomer(UserCustomer customer) throws ResourceNotCreatedException;

    List<UserCustomer> getCustomers(String email) throws ResourceNotFoundException;

}
