package com.example.restapi.Service;



import com.example.restapi.Model.Customer;

import java.util.List;


public interface CustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomer();

    Customer getCustomersById(Long ID);

    Customer updateCustomer (Customer customer, long id);

    void deleteCustomer(long id);
}
