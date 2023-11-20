package com.example.restapi.Service.Impl;


import com.example.restapi.Exception.ResourceNotFound;
import com.example.restapi.Model.Customer;
import com.example.restapi.Repository.CustomerRepository;
import com.example.restapi.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Create/Save
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
            return customerRepository.findAll();
    }

    @Override
    public Customer getCustomersById(Long ID) {
        Optional<Customer> optionalCustomer = customerRepository.findById(ID);
        if (optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }else {
            throw new ResourceNotFound("Products", "ID", ID);
        }
    }

    public Customer updateCustomer (Customer customer, long id) {
        Customer excustomer = customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Customer", "ID", id)
        );
        excustomer.setCustomerName(customer.getCustomerName());
        excustomer.setCustomerEmail(customer.getCustomerEmail());
        excustomer.setCustomerPassword(customer.getCustomerPassword());

        customerRepository.save(excustomer);
        return excustomer;
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Products", "ID", id)
        );
        customerRepository.deleteById(id);
    }
}
